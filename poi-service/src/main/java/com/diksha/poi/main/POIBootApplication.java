package com.diksha.poi.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class POIBootApplication {
	
	@Bean
	public PropertySourcesPlaceholderConfigurer configurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	public static void main(String[] args) {
		SpringApplication.run(POIBootApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplateWithoutEureka(){
		return new RestTemplate();
	}
}
