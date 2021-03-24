package com.mailchimp.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import net.bytebuddy.asm.Advice.Return;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	private ApiInfo apiInfo() {
		        return new ApiInfo("Mailchimp Campaign API", "These API permite to get list campaigns and get individual campaign from mailchimp. You can add campaign and campaign folder in mailchimp and also can delete,send and update.", "API v1.0.1", "Terms of service",
		          new Contact("rasel-machette","http://localhost:8080/swagger-ui", "md.rasel@machette.tech"),
		          "License of API", "API license URL", Collections.emptyList());
		    }
    
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
          .select()
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())
          .build();
    }
	


	
	 @Bean
	    UiConfiguration uiConfig() {
		 
			        return UiConfigurationBuilder.builder()
			          .deepLinking(true)
			          .displayOperationId(false)
			          .defaultModelsExpandDepth(1)
			          .defaultModelExpandDepth(1)
			          .defaultModelRendering(ModelRendering.EXAMPLE)
			          .displayRequestDuration(false)
			          .docExpansion(DocExpansion.NONE)
			          .filter(false)
			          .maxDisplayedTags(null)
			          .operationsSorter(OperationsSorter.ALPHA)
			          .showExtensions(false)
			          .tagsSorter(TagsSorter.ALPHA)
			          //.supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
			          .validatorUrl(null)
			          .build();
		    }

			
	    
	
}
