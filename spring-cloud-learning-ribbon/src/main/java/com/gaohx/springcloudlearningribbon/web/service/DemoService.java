package com.gaohx.springcloudlearningribbon.web.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DemoService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getMsgFallback",
            commandProperties = {
                    //@HystrixProperty(name = "executionTimeoutInMilliseconds",value = "500")
            }
    )
    public String getMsg() {
        return restTemplate.postForObject("http://service-provider/getMsg", null, String.class);
    }

    private String getMsgFallback() {
        return "getMsg() fail";
    }

}
