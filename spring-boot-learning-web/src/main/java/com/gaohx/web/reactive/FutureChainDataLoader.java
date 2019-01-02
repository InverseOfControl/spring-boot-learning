package com.gaohx.web.reactive;

import java.util.concurrent.*;

public class FutureChainDataLoader extends DataLoader {

    @Override
    protected void doLoad() {
        CompletableFuture future = new CompletableFuture();
        future.thenRunAsync(super::loadConfigurations);
        System.out.println("====111===");
        future.thenRunAsync(super::loadUsers);
        System.out.println("====222===");

        /*CompletableFuture
                .runAsync(super::loadConfigurations)
                .thenRun(super::loadUsers)
                .thenRun(super::loadOrders)
                .whenComplete((result, throwable) -> { // 完成时回调
                    System.out.println("加载完成");
                }).join(); // 等待完成*/
    }

    public static void main(String[] args) {
        new FutureChainDataLoader().load();
    }
}