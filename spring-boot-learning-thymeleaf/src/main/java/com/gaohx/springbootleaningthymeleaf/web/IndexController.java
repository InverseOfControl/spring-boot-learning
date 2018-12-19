package com.gaohx.springbootleaningthymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(HttpServletRequest request){
        request.setAttribute("msg","hello12345678");
        return "index";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request){
        return "login";
    }

    @GetMapping("/getUser")
    public String getUser(HttpServletRequest request){
        return "login";
    }

}
