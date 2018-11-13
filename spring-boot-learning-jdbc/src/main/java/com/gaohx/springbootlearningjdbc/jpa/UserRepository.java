package com.gaohx.springbootlearningjdbc.jpa;

import com.gaohx.springbootlearningjdbc.domain.City;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<City,Long> {

    City findByName(String name);

    City findById(Long id);

}
