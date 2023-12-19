package com.postServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PostServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostServicesApplication.class, args);
	}

}
