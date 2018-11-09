package com.gaohx.springcloudlearningribbon.web.controller;

import com.gaohx.springcloudlearningribbon.web.service.DemoService;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("getMsg")
    @HystrixCommand(fallbackMethod = "getMsgFallback",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
            }
    )
    public String getMsg() {
        return restTemplate.postForObject("http://service-provider/getMsg", null, String.class);
    }

    private String getMsgFallback() {
        return "getMsg() fail";
    }

}
