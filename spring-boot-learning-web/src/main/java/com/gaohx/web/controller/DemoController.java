package com.gaohx.web.controller;

import com.gaohx.web.annotation.MyAnnotation;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@MyAnnotation(key = "aaa", values = "bbb")
public class DemoController {

    // 线程安全的map
    static final Map<String, Object> map = Collections.synchronizedMap(new HashMap());

    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "Long"),
    })
    @GetMapping("/demo1")
    public Object demo1(String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("a", 1);
        map.put("b", 1);
        map.put("c", name);
        return map;
    }

    @GetMapping(path = {"demo2", "demo3"})
    public String demo2() {
        System.out.println("DemoController.555666");
        return "Hello World";
    }

    @GetMapping(path = {"demo4"})
    public ResponseEntity demo3(@RequestHeader(name = "aaa", required = true) String aaa) {
        MultiValueMap httpHeaders = new HttpHeaders();
        httpHeaders.add("MyHeader", "1111");
        ResponseEntity entity = new ResponseEntity("123", httpHeaders, HttpStatus.OK);
        return entity;
    }

}
