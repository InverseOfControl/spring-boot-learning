package com.gaohx.springbootlearningjdbc.service;

import com.gaohx.springbootlearningjdbc.dao.CityMapper;
import com.gaohx.springbootlearningjdbc.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;
import java.util.List;

@Service(value = "mybatisService")
public class MybatisServiceImpl implements MybatisService {

    @Autowired(required = false)
    private CityMapper cityMapper;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public City getCity(String id) {
        return cityMapper.selectByPrimaryKey(BigDecimal.valueOf(Long.valueOf(id)));
    }

    @Override
    public List<City> getCityList() {
        /*City city = new City();
        city.setId(BigDecimal.valueOf(1113));
        city.setName("李四");
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    cityMapper.insert(city);
                } catch (Exception e) {
                    status.setRollbackOnly();
                }
            }
        });*/
        return cityMapper.getCityList("1110");
    }
}
