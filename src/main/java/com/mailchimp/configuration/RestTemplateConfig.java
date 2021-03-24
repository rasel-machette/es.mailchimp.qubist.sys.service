package com.mailchimp.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
public class RestTemplateConfig {
	@Value("${campaign.userName}")
	String campaignUserName;
	@Value("${campaign.password}")
	String campaignPassword;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.basicAuthentication(campaignUserName, campaignPassword).build();

	}

}
