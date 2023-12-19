package com.commentServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CommentServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentServicesApplication.class, args);
	}

}
