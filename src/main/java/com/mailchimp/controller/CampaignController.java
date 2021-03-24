package com.mailchimp.controller;
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
import com.mailchimp.service.CampaignService;
import com.mailchimp.entities.addCampaign.AddPostCampaign;
import com.mailchimp.entities.campaignFolder.CampaignFolder;
import com.mailchimp.entities.updateCampaignSettings.UpdateCampaignSettings;

@RestController
@RequestMapping("/response")
public class CampaignController {

	@Autowired
	private CampaignService campaignService;

	
    @GetMapping(
   	        value = "/getCampaigns",
   	        produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCampaigns() {
          
    	 return campaignService.getCampaigns();
   	     }

     
   @PostMapping(
    	        value = "/addPostCampaign",
    	        consumes = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<Reponse> addPostCampaign(@RequestBody AddPostCampaign postcampaign) {
           
    	        return campaignService.addPostCampaign(postcampaign);
           }
     

   @PostMapping(
    	        value = "/createCampaignFolder",
    	        consumes = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<Reponse> addCampaignFolder(@RequestBody CampaignFolder campaignfolder) { 
           
    	 return campaignService.addCampaignFolder(campaignfolder);
           
           }
     
   
  @GetMapping(
  	        value = "/getCampaignInfo/{campaignKey}",
  	        produces = MediaType.APPLICATION_JSON_VALUE)
   public String getCampaignKey(@PathVariable String campaignKey )  {
    	 return campaignService.getCampaignInfo(campaignKey);
  	    
  	      }
     
     @PatchMapping(
   	        value = "/updateCampaign/{campaignKey}",
   	        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reponse> updateCampaign(@RequestBody  UpdateCampaignSettings updateCampaignSettings, @PathVariable String campaignKey )  {
    	     return campaignService.updateCampaign(updateCampaignSettings, campaignKey);
             }
       
     @DeleteMapping(
 	        value = "/deleteCampaign/{campaignKey}"
 	        )
  public ResponseEntity<Reponse>deleteCampaign(@PathVariable String campaignKey ){
    	 return campaignService.deleteCampaign(campaignKey);
        
 	    }
     
    
     @PostMapping(
  	        value = "/sendCampaign/{campaignKey}")
  	      //produces = MediaType.APPLICATION_JSON_VALUE)
  	        
   public ResponseEntity<Reponse> sendCampaign(@PathVariable String campaignKey ){
           return campaignService.sendCampaign(campaignKey);
    
     }
}