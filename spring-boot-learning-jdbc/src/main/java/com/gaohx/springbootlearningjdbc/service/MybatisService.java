package com.gaohx.springbootlearningjdbc.service;

import com.gaohx.springbootlearningjdbc.model.City;

import java.util.List;

public interface MybatisService {

    City getCity(String id);

    List<City> getCityList();

}
