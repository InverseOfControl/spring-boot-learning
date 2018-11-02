package com.gaohx.springbootlearningconfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.web.context.support.StandardServletEnvironment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringBootLearningConfigurationApplication{

    public static void main(String[] args) {
        SpringApplication context = new SpringApplication(SpringBootLearningConfigurationApplication.class);
        context.addListeners(new MyListener());
        context.run(args);
    }

    static class MyListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

        @Override
        public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
            ConfigurableEnvironment environment = applicationEnvironmentPreparedEvent.getEnvironment();
            Map<String, Object> map = new HashMap<>();
            map.put("a", 1);
            map.put("b", 2);
            PropertySource propertySource = new MapPropertySource("mysource", map);
            environment.getPropertySources().addLast(propertySource);
        }
    }

}
