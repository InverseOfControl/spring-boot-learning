package com.gaohx.springbootlearningjdbc.service;

import com.gaohx.springbootlearningjdbc.dao.CityMapper;
import com.gaohx.springbootlearningjdbc.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service(value = "mybatisService")
public class MybatisServiceImpl implements MybatisService {

    @Autowired(required = false)
    private CityMapper cityMapper;

    @Override
    public City getCity(String id) {
        return cityMapper.selectByPrimaryKey(BigDecimal.valueOf(Long.valueOf(id)));
    }

    @Override
    public List<City> getCityList() {
        return cityMapper.getCityList("1110");
    }
}
