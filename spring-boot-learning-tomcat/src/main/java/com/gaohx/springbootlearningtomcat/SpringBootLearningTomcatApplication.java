package com.gaohx.springbootlearningtomcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.*;
import org.springframework.context.annotation.Bean;

import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.Set;

@SpringBootApplication
public class SpringBootLearningTomcatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLearningTomcatApplication.class, args);
	}

	@Bean
	public static WebServerFactoryCustomizer webServerFactoryCustomizer(){
		return new WebServerFactoryCustomizer() {
			@Override
			public void customize(WebServerFactory factory) {
				if(factory instanceof TomcatServletWebServerFactory){
					TomcatServletWebServerFactory tomcat =
							TomcatServletWebServerFactory.class.cast(factory);
					tomcat.setContextPath("/");
					tomcat.setPort(8886);
					tomcat.setUriEncoding(Charset.defaultCharset());
				}
			}
		};
	}
}
