package com.gaohx.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafDemoController {

    @GetMapping("/index")
    public ModelAndView index(ModelAndView model) {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setName("张三");
        user.setAge("20");
        list.add(user);
        model.addObject(user);
        model.addObject("users",list);
        model.setViewName("index");
        return model;
    }

}

class User {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
