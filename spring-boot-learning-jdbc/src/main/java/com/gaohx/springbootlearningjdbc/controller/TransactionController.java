package com.gaohx.springbootlearningjdbc.controller;

import com.gaohx.springbootlearningjdbc.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transaction")
    public Long transaction() {
        Long startTime = System.currentTimeMillis();
        transactionService.execute();
        return System.currentTimeMillis() - startTime;
    }

}
