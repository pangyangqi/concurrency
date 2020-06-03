package com.pyq.concurrency.juc.demo8;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Yangqi.Pang
 * @date 2020-06-02 22:50
 */
public class BlockingQueueDemo3 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String>  blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.put("1");
        blockingQueue.put("2");
        blockingQueue.put("3");


        System.out.println("blockingQueue.poll() = " + blockingQueue.take());
        System.out.println("blockingQueue.poll() = " + blockingQueue.take());
        System.out.println("blockingQueue.poll() = " + blockingQueue.take());
        System.out.println("blockingQueue.poll() = " + blockingQueue.take());
        System.out.println("blockingQueue.poll() = " + blockingQueue.take());

    }
}
