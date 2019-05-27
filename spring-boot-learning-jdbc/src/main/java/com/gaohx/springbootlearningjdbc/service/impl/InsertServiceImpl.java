package com.gaohx.springbootlearningjdbc.service.impl;

import com.gaohx.springbootlearningjdbc.dao.RoleMapper;
import com.gaohx.springbootlearningjdbc.dao.UserMapper;
import com.gaohx.springbootlearningjdbc.model.Role;
import com.gaohx.springbootlearningjdbc.model.User;
import com.gaohx.springbootlearningjdbc.service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InsertServiceImpl implements InsertService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired(required = false)
    private RoleMapper roleMapper;

    @Override
    public String insertUser(User user) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userMapper.insert(user);
        //System.out.println(1 / 0);
        return "success";
    }

    @Override
    public String insertRole(Role role) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        roleMapper.insert(role);
        return "success";
    }
}
