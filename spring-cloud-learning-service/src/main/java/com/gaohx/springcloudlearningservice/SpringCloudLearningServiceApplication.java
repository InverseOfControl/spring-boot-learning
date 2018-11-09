package com.gaohx.springcloudlearningservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudLearningServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudLearningServiceApplication.class, args);
	}
}
