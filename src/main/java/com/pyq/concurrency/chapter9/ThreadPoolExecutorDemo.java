package com.pyq.concurrency.chapter9;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author Yangqi.Pang
 * @date 2020-03-25 21:41
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        Executors.newFixedThreadPool(5);
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(5,5,6000L, TimeUnit.DAYS,  new LinkedBlockingQueue<Runnable>(),namedThreadFactory);
        for(int i = 0 ;i <100;i++){
            executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        executorService.shutdown();
    }
}
