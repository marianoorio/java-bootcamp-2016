package com.bootcamp.Topic6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * Application class to run SpringApplication
 * Makes the UsersController executable
 *
*/
@SpringBootApplication
public class Application {
	
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
	
}
