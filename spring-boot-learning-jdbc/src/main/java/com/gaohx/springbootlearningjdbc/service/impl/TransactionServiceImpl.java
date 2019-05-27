package com.gaohx.springbootlearningjdbc.service.impl;

import com.gaohx.springbootlearningjdbc.model.Role;
import com.gaohx.springbootlearningjdbc.model.User;
import com.gaohx.springbootlearningjdbc.service.InsertService;
import com.gaohx.springbootlearningjdbc.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private InsertService insertService;

    @Autowired
    private PlatformTransactionManager txManager;

    @Override
    public void execute() {
        User user = new User();
        user.setId(2);
        user.setName("李四");
        user.setAge(40);

        Role role = new Role();
        role.setId(2);
        role.setRole("3");
        role.setRemark("测试");

        List<Map<CompletableFuture, TransactionStatus>> list = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<TransactionStatus> transactionStatuses = new ArrayList<>();

        Future future1 = executorService.submit(() -> {
            DefaultTransactionDefinition def = new DefaultTransactionDefinition();
            def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
            TransactionStatus status = txManager.getTransaction(def);
            transactionStatuses.add(status);
            insertService.insertUser(user);
        });

        Future future2 = executorService.submit(() -> {
            DefaultTransactionDefinition def = new DefaultTransactionDefinition();
            def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
            TransactionStatus status = txManager.getTransaction(def);
            transactionStatuses.add(status);
            insertService.insertRole(role);
        });

        try {
            System.out.println(future1.get());
            System.out.println(future2.get());
            for (TransactionStatus transactionStatus : transactionStatuses) {
                txManager.commit(transactionStatus);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
