package com.pyq.concurrency.juc.demo13;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Yangqi.Pang
 * @date 2020-06-12 16:55
 */
public class Test1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+"runAsync Void");
//        });
//
//
//        System.out.println("fdsifgjdkslj");
//
//        completableFuture.get();

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName() + "supplyAsync Integer");

            int i = 10/1;
            return 1024;
        });

        completableFuture.whenComplete((t,u) ->{
            System.out.println("t = " + t);
            System.out.println("u = " + u);
        }).exceptionally(throwable -> {
            System.out.println(throwable.getMessage());
            return 111;
        });
    }
}
