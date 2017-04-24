package com.bootcamp.Topic6.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@SpringBootApplication
// Why this config send 404 status? is because are in other packages??
/**
 * 
 * Application class to run SpringApplication
 * Makes the UsersController executable
 *
 */
@Configuration
@ComponentScan(basePackages = "com.bootcamp.Topic6.Controllers")
@EnableAutoConfiguration
@EnableWebMvc
public class Application {
	
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
}
