package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestDemoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(RestDemoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
		log.info("READY....");
		
	}
}
