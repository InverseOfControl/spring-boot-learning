package com.gaohx.web;

import javax.security.auth.callback.Callback;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newScheduledThreadPool(10);
        Callable<String> task = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "123";
            }
        };
        Future<String> future = executorService.submit(task);
        String obj = future.get();
        System.out.println(obj);
    }
}
