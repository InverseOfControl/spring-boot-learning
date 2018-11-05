package com.gaohx.springcloudlearningconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class SpringCloudLearningConfigServerApplication {

	private final ContextRefresher contextRefresher;

	public SpringCloudLearningConfigServerApplication(ContextRefresher contextRefresher)
	{
		this.contextRefresher = contextRefresher;
	}

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.home"));
		System.out.println(System.getProperty("user.dir"));
		SpringApplication.run(SpringCloudLearningConfigServerApplication.class, args);
	}

	@GetMapping("refresh")
	public void refresh(){
		Set<String> set = contextRefresher.refresh();
		System.out.println("本次更新："+set);
	}

}
