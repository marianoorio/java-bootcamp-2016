package globant.javabootcamp.finalproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * Configuration of swagger anotations
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)  
		          .select()                                  
		          .apis(RequestHandlerSelectors.basePackage("globant.javabootcamp.finalproject"))              
		          .paths(PathSelectors.any())                      
		          .build()
		          .apiInfo(apiInfo());                                           
	}
	
	private ApiInfo apiInfo() {
	    ApiInfo apiInfo = new ApiInfo(
	      "REST Api using SpringBoot",
	      "Resolution Final Project of Globant's Java BootCamp",
	      "1.0-SNAPSHOT",
	      "Terms of service",
	      "mariano.orio@hotmail.com",
	      "License of API",
	      "API license URL");
	    return apiInfo;
	}


}
