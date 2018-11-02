package com.gaohx.springbootlearningconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo/{str}")
    public Object demo(@PathVariable String str){
        return System.getenv().get(str);
    }

}
