package com.pyq.concurrency.juc.demo9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Yangqi.Pang
 * @date 2020-06-03 16:35
 */
public class ThreadLocalPoolDemo {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            for (int i = 1; i <= 100; i++) {
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " ok");
                });
            }
        }finally {
            executorService.shutdown();
        }
    }
}
