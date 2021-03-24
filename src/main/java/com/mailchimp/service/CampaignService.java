package com.mailchimp.service;

import java.nio.charset.Charset;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import com.mailchimp.model.Reponse;
import com.mailchimp.controller.CampaignController;
import com.mailchimp.entities.addCampaign.AddPostCampaign;
import com.mailchimp.entities.campaignFolder.CampaignFolder;
import com.mailchimp.entities.updateCampaignSettings.UpdateCampaignSettings;

@Service
public class CampaignService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CampaignController.class);
	@Value("${campaign.uri}")
	String campaignUri;
    @Autowired
	private RestTemplate restTemplate;

	 public String getCampaigns() {
		LOGGER.debug("Request{}");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		try {
			String response = restTemplate.exchange(campaignUri + "campaigns", HttpMethod.GET, entity, String.class)
					.getBody();

			LOGGER.debug("Response{}", response);
			LOGGER.info("Success");
			return response;
		  }

		catch (Exception e) {

			return "Campaigns NOT FOUND";

		}
	}

	
	public ResponseEntity<Reponse> addPostCampaign(AddPostCampaign postcampaign) {
		LOGGER.debug("Request{}");

		Reponse resp = new Reponse();
		resp.setNombre("Added Campaign");
		resp.setRegistros_status("SUCCESS");
		LOGGER.info("Added Campaign");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<AddPostCampaign> entity = new HttpEntity<AddPostCampaign>(postcampaign, headers);
		try {
			LOGGER.debug("Response{}", restTemplate
					.exchange(campaignUri + "campaigns", HttpMethod.POST, entity, AddPostCampaign.class).getBody());
			LOGGER.info("Success");
			return new ResponseEntity<Reponse>(resp, HttpStatus.CREATED);
		    } 
		
		catch (Exception e) {
			LOGGER.error("The requested resource could not be found");
			resp.setRegistros_status("FAILED");
			resp.setRegistros_fallidos(resp.getRegistros_fallidos() + 1);
			return new ResponseEntity<Reponse>(resp, HttpStatus.NOT_FOUND);

		}
	}


	public ResponseEntity<Reponse> addCampaignFolder(CampaignFolder campaignfolder) {
		LOGGER.debug("Request{}");
		Reponse resp = new Reponse();
		resp.setNombre("Adding Campaign Folder");
		resp.setRegistros_status("SUCCESS");
		LOGGER.info("Adding Campaign Folder");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<CampaignFolder> entity = new HttpEntity<CampaignFolder>(campaignfolder, headers);
		try {
			LOGGER.debug("Response{}",
					restTemplate
							.exchange(campaignUri + "campaign-folders", HttpMethod.POST, entity, CampaignFolder.class)
							.getBody());
			LOGGER.info("Success");
			return new ResponseEntity<Reponse>(resp, HttpStatus.CREATED);
		   } 
		
		catch (Exception e) {
			LOGGER.error("The requested resource could not be found");
			resp.setRegistros_status("FAILED");
			resp.setRegistros_fallidos(resp.getRegistros_fallidos() + 1);
			return new ResponseEntity<Reponse>(resp, HttpStatus.NOT_FOUND);
		}
	}


	public String getCampaignInfo(String campaignKey) {
		LOGGER.debug("Request{}", campaignKey);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		try {
			String response = restTemplate
					.exchange(campaignUri + "campaigns/" + campaignKey, HttpMethod.GET, entity, String.class).getBody();
			LOGGER.debug("Response{}", response);
			LOGGER.info("Success");
			return response;
		   }

		catch (Exception e) {
			return "CampaignKey: " + campaignKey + " NOT FOUND";

		}
	}

	
	public ResponseEntity<Reponse> updateCampaign(UpdateCampaignSettings updateCampaignSettings, String campaignKey) {
		LOGGER.debug("Request{}", campaignKey);

		Reponse resp = new Reponse();
		resp.setNombre("Updating Campaign Settings");
		resp.setRegistros_status("SUCCESS");
		LOGGER.info("Updating Campaign Settings");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<UpdateCampaignSettings> entity = new HttpEntity<UpdateCampaignSettings>(updateCampaignSettings,
				headers);
		try {
			LOGGER.debug("Response{}", restTemplate.exchange(campaignUri + "campaigns/" + campaignKey, HttpMethod.PATCH,
					entity, UpdateCampaignSettings.class).getBody());
			LOGGER.info("Success");
			return new ResponseEntity<Reponse>(resp, HttpStatus.OK);
		      } 
		
		catch (Exception e) {
			LOGGER.error("The requested resource could not be found");
			resp.setRegistros_status("FAILED");
			resp.setRegistros_fallidos(resp.getRegistros_fallidos() + 1);
			return new ResponseEntity<Reponse>(resp, HttpStatus.NOT_FOUND);
		}
	}


	public ResponseEntity<Reponse> deleteCampaign(String campaignKey) {
		LOGGER.debug("Request{}", campaignKey);

		Reponse resp = new Reponse();
		resp.setNombre("Deleting Campaign");
		resp.setRegistros_status("SUCCESS");
		LOGGER.info("Deleting Campaign");
		HttpHeaders headers = new HttpHeaders();
		// headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		try {
			LOGGER.debug("Response{}",
					restTemplate
							.exchange(campaignUri + "campaigns/" + campaignKey, HttpMethod.DELETE, entity, String.class)
							.getBody());
			LOGGER.info("Success");
			return new ResponseEntity<Reponse>(resp, HttpStatus.NO_CONTENT);
		     }

		catch (Exception e) {
			LOGGER.error("The requested resource could not be found");
			resp.setRegistros_status("FAILED");
			resp.setRegistros_fallidos(resp.getRegistros_fallidos() + 1);
			return new ResponseEntity<Reponse>(resp, HttpStatus.NOT_FOUND);
		}

	}


	public ResponseEntity<Reponse> sendCampaign(String campaignKey) {
		LOGGER.debug("Request{}", campaignKey);

		Reponse resp = new Reponse();
		resp.setNombre("Sending Campaign");
		resp.setRegistros_status("SUCCESS");
		LOGGER.info("Sending Campaign");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		try {
			LOGGER.debug("Response{}", restTemplate.exchange(// campaigns/{campaign_id}/actions/send
					campaignUri + "campaigns/" + campaignKey + "/actions/send", HttpMethod.POST, entity, String.class)
					.getBody());
			LOGGER.info("Success");
			return new ResponseEntity<Reponse>(resp, HttpStatus.NO_CONTENT);
		   }

		catch (Exception e) {
			LOGGER.error("The requested resource could not be found");
			resp.setRegistros_status("Campaign already sent");
			resp.setRegistros_fallidos(resp.getRegistros_fallidos() + 1);
			return new ResponseEntity<Reponse>(resp, HttpStatus.NOT_FOUND);
		}
	}

}
