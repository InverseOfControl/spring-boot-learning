package com.gaohx.springbootlearningjdbc.service;

import com.gaohx.springbootlearningjdbc.domain.City;
import com.gaohx.springbootlearningjdbc.jpa.UserRepository;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private HikariDataSource dataSource;

    private final UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public boolean saveUser(City user) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from dual");
            if(resultSet.next()){
                System.out.println(resultSet.getString("DUMMY"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public City getUser(String id) {
        return userRepository.findById(Long.valueOf(id));
    }
}
