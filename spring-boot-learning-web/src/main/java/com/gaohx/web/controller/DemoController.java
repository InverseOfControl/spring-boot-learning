package com.gaohx.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo1")
    public String demo1() {
        System.out.println("DemoController.555");
        return "Hello World";
    }

    @GetMapping(path = {"demo2", "demo3"})
    public String demo2() {
        System.out.println("DemoController.555");
        return "Hello World";
    }

    @GetMapping(path = {"demo4"})
    public ResponseEntity demo3(@RequestHeader(name = "aaa",required = true) String aaa ) {
        MultiValueMap httpHeaders = new HttpHeaders();
        httpHeaders.add("MyHeader", "1111");
        ResponseEntity entity = new ResponseEntity("123", httpHeaders, HttpStatus.OK);
        return entity;
    }

}
