package com.pyq.concurrency.juc.demo8;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Yangqi.Pang
 * @date 2020-06-02 22:50
 */
public class BlockingQueueDemo4 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String>  blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.offer("a",2, TimeUnit.SECONDS);
        blockingQueue.offer("a",2, TimeUnit.SECONDS);
        blockingQueue.offer("a",2, TimeUnit.SECONDS);
        blockingQueue.offer("a",2, TimeUnit.SECONDS);

        System.out.println("blockingQueue.poll(2,TimeUnit.SECONDS) = " + blockingQueue.poll(2, TimeUnit.SECONDS));
        System.out.println("blockingQueue.poll(2,TimeUnit.SECONDS) = " + blockingQueue.poll(2, TimeUnit.SECONDS));
        System.out.println("blockingQueue.poll(2,TimeUnit.SECONDS) = " + blockingQueue.poll(2, TimeUnit.SECONDS));
        System.out.println("blockingQueue.poll(2,TimeUnit.SECONDS) = " + blockingQueue.poll(2, TimeUnit.SECONDS));

    }
}
