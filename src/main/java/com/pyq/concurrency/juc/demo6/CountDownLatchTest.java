package com.pyq.concurrency.juc.demo6;

import java.util.concurrent.CountDownLatch;

/**
 * @author Yangqi.Pang
 * @date 2020-05-25 21:05
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "go on");
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("close the door");

    }
}
