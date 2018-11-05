package com.gaohx.springcloudlearningeurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudLearningEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudLearningEurekaClientApplication.class, args);
	}
}
