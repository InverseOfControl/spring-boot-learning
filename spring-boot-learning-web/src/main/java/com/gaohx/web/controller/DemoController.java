package com.gaohx.web.controller;

import com.gaohx.web.annotation.MyAnnotation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@MyAnnotation(key = "aaa",values = "bbb")
public class DemoController {

    @GetMapping("/demo1")
    public Object demo1(String name) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("a",1);
        map.put("b",1);
        map.put("c",name);
        return map;
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
