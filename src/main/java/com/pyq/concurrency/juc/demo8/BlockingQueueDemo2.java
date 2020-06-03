package com.pyq.concurrency.juc.demo8;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Yangqi.Pang
 * @date 2020-06-02 22:50
 */
public class BlockingQueueDemo2 {
    public static void main(String[] args) {
        BlockingQueue<String>  blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println("blockingQueue.offer(\"1\") = " + blockingQueue.offer("1"));
        System.out.println("blockingQueue.offer(\"2\") = " + blockingQueue.offer("2"));
        System.out.println("blockingQueue.offer(\"3\") = " + blockingQueue.offer("3"));
        System.out.println("blockingQueue.offer(\"4\") = " + blockingQueue.offer("4"));
        System.out.println("blockingQueue.peek() = " + blockingQueue.peek());


        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());

    }
}
