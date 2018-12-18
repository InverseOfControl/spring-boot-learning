package com.gaohx.session.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SessionController {

    @GetMapping("/setSession")
    public Map setSession(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        request.getSession().setAttribute("message",request.getRequestURL());
        map.put("request url",request.getRequestURL());
        return map;
    }

    @GetMapping("/getSession")
    public Map getSession(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("sessionId",request.getSession().getId());
        map.put("request url",request.getSession().getAttribute("message"));
        return map;
    }


}
