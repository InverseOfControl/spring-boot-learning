package com.gaohx.springbootlearningjdbc.service;

import com.gaohx.springbootlearningjdbc.model.Role;
import com.gaohx.springbootlearningjdbc.model.User;

public interface InsertService {

    String insertUser(User user);

    String insertRole(Role role);

}
