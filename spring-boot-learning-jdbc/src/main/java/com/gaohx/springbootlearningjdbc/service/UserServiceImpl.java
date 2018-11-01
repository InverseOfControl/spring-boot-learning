package com.gaohx.springbootlearningjdbc.service;

import com.gaohx.springbootlearningjdbc.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


@EnableTransactionManagement
@Service
public class UserServiceImpl implements UserService {
    @Override
    @Transactional
    public void saveUser(User user) {

    }
}
