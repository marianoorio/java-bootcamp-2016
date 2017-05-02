package com.bootcamp.Topic6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)  
		          .select()                                  
		          .apis(RequestHandlerSelectors.basePackage("com.bootcamp.Topic6.Controllers"))              
		          .paths(PathSelectors.any())                      
		          .build()
		          .apiInfo(apiInfo());                                           
	}
	
	private ApiInfo apiInfo() {
	    ApiInfo apiInfo = new ApiInfo(
	      "REST Api using SpringBoot",
	      "Resolution of exersice 3 of Topic 6",
	      "API TOS",
	      "Terms of service",
	      "mariano.orio@hotmail.com",
	      "License of API",
	      "API license URL");
	    return apiInfo;
	}


}
