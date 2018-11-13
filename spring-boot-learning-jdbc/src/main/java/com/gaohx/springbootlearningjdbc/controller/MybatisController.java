package com.gaohx.springbootlearningjdbc.controller;

import com.gaohx.springbootlearningjdbc.model.City;
import com.gaohx.springbootlearningjdbc.service.MybatisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MybatisController {

    private static final Logger logger = LoggerFactory.getLogger(MybatisController.class);

    @Autowired
    private MybatisService mybatisService;

    @GetMapping("getCity/{id}")
    public City getCity(@PathVariable String id){
        logger.info("=========开始=========");
        return mybatisService.getCity(id);
    }

    @GetMapping("getCityList")
    public List<City> getCityList(){
        return mybatisService.getCityList();
    }

}
