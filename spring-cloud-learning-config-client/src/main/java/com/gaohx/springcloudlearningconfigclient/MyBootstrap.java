package com.gaohx.springcloudlearningconfigclient;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBootstrap implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        applicationContext.getEnvironment();
    }
}
