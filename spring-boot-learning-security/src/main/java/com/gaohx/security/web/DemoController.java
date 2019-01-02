package com.gaohx.security.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/index")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String index() {
        return "index";
    }

}
