package com.betacom.jpa.fe.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

	@Bean
	WebClient jpaWebClient(@Value("${jpa_backend}") String backendURL) {
		
		return WebClient.builder()
				.baseUrl(backendURL)
				.build();
		
	}
	
}
