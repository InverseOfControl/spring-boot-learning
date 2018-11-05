package com.gaohx.springcloudlearningeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudLearningEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudLearningEurekaServerApplication.class, args);
	}
}
