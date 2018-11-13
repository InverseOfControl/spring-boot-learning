package com.gaohx.springbootlearningjdbc.service;

import com.gaohx.springbootlearningjdbc.domain.City;

public interface UserService {
    boolean saveUser(City user);
    City getUser(String name);
}
