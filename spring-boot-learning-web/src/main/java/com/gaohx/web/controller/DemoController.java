package com.gaohx.web.controller;

import com.gaohx.web.mq.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private Producer producer;

    @GetMapping("/demo")
    public String demo(){
        producer.send();
        return "Hello World";
    }
}
