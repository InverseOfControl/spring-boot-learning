package com.gaohx.springbootlearningjdbc.service;

import com.gaohx.springbootlearningjdbc.domain.User;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private HikariDataSource dataSource;

    @Override
    @Transactional
    public boolean saveUser(User user) {
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
}
