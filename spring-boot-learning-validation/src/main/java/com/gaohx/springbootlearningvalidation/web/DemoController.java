package com.gaohx.springbootlearningvalidation.web;

import com.gaohx.springbootlearningvalidation.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class DemoController {
    @GetMapping("/validate")
    public String validate(@Valid User user) {
        return "校验成功";
    }
}

