package com.gaohx.web.async;


import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Component
public class AsyncTask {

    Random random = new Random();

    public CompletableFuture doTaskOne() throws Exception{
        System.out.println("任务一开始");

        Thread.sleep(random.nextInt(10000));

        System.out.println("任务一结束");

        return new CompletableFuture();
    }

}
