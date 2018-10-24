package com.gaohx.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.ParentContextCloserApplicationListener;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        Map<String, Object> defaultProperties = new HashMap<String, Object>();
        defaultProperties.put("aaa", 111);
        defaultProperties.put("server.port", "8080");
        new SpringApplicationBuilder(SpringBootDemoApplication.class).properties(defaultProperties).run(args);
    }
}
