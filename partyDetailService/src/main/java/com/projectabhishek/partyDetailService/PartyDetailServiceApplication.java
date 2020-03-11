package com.projectabhishek.partyDetailService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication is a meta-annotation that pulls in component scanning, autoconfiguration, and property support.
 * Spring boot fires up a Servlet container
 */
@SpringBootApplication
public class PartyDetailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartyDetailServiceApplication.class, args);
	}

}
