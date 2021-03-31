package com.mailchimp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import com.mailchimp.controller.CampaignController;
import com.mailchimp.service.CampaignService;
import junit.framework.Assert;
import com.mailchimp.controller.CampaignController;
import com.mailchimp.service.CampaignService;



@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CampaignControllerTest {
	@LocalServerPort
	int randomServerPort;
	// @Value("${jira.uri}")
	String campaignUri = "http://localhost:8080/response/";
	@Autowired
	private MockMvc mockMvc;
	@Mock
	private CampaignService campaignService;
	@InjectMocks
	CampaignController campaignController;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(campaignController).build();
	}
	
	

	@Test
	public void testgetCampaignss() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = campaignUri + "/getCampaigns";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("9cc4f7ff6e"));
	}
	
	
 
	@Test
	public void testgetCampaignInfo() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = campaignUri + "/getCampaignInfo/8283e98496";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("9cc4f7ff6e"));
	}
	
	


     @Test
        public void testCreateIssue() throws Exception {

        	String json =  "{\"type\":\"regular\",\"recipients\":{\"list_id\":\"9c"
        			+ "c4f7ff6e\",\"segment_opts\":{\"saved_"
        			+ "segment_id\":0,\"prebuilt_segment_id\":\"\",\"m"
        			+ "atch\":\"any\",\"conditions\":[]}},\"settings\":{\"sub"
        			+ "ject_line\":\"Mr. Jhon\",\"preview_text\":\"\",\"titl"
        			+ "e\":\"Demo18\",\"from_name\":\"rasel I machett"
        			+ "e\",\"reply_to\":\"md.rasel@machette.tech\",\"use_conver"
        			+ "sation\":false,\"to_name\":\"\",\"folder_id\":\"\",\"authentic"
        			+ "ate\":false,\"auto_footer\":false,\"inline_css\":false,\"auto_tw"
        			+ "eet\":false,\"auto_fb_post\":[],\"fb_comments\":false,\"templa"
        			+ "te_id\":0},\"tracking\":{\"opens\":false,\"html_clicks\":fa"
        			+ "lse,\"text_clicks\":false,\"goal_tracking\":false,\"ecomm3"
        			+ "60\":false,\"google_analytics\":\"\",\"clicktale\":\"\",\"sales"
        			+ "force\":{\"campaign\":false,\"notes\":false},\"caps"
        			+ "ule\":{\"notes\":false}},\"social_card\":{\"ima"
        			+ "ge_url\":\"\",\"description\":\"\",\"title\":\"\"},\"conten"
        			+ "t_type\":\"template\"}";
            mockMvc.perform(post( "/response/addPostCampaign")
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(json))
                    .andExpect(status().isCreated())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.registros_status").exists());
            
     }     
     

  @Test
     public void testCampaignFolder() throws Exception {

     	String json =  "{\"name\":\"Demo13\"}";
     	        
     	        		
         mockMvc.perform(post( "/response/createCampaignFolder")
                 .contentType(MediaType.APPLICATION_JSON_VALUE)
                 .content(json))
                 .andExpect(status().isCreated())
                 .andExpect(MockMvcResultMatchers.jsonPath("$.registros_status").exists());
         

    }
    

       @Test
        public void testDeleteCampaign() throws Exception 
        {
     	mockMvc.perform(delete("/response/deleteCampaign/f2db4d6c16"))
             .andExpect(status().isNoContent());
       }
      

       @Test
        public void testSendCampaign() throws Exception 
        {
     	mockMvc.perform(post("/response/sendCampaign/4fece34126"))
             .andExpect(status().isNoContent());
       }
       

}
