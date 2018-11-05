package com.gaohx.springcloudlearningbootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudLearningBootstrapApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringCloudLearningBootstrapApplication.class);
		application.run(args);
	}
}
