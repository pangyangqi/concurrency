package com.pyq.concurrency.juc.demo8;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Yangqi.Pang
 * @date 2020-06-02 22:50
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String>  blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println("blockingQueue.add(\"1\") = " + blockingQueue.add("1"));;
        System.out.println("blockingQueue.add(\"2\") = " + blockingQueue.add("2"));;
        System.out.println("blockingQueue.add(\"3\") = " + blockingQueue.add("3"));;
//        System.out.println("blockingQueue.add(\"4\") = " + blockingQueue.add("4"));;
        System.out.println("blockingQueue.element() = " + blockingQueue.element());;

        System.out.println("blockingQueue.remove(1) = " + blockingQueue.remove());
        System.out.println("blockingQueue.remove(2) = " + blockingQueue.remove());
        System.out.println("blockingQueue.remove(3) = " + blockingQueue.remove());
//        System.out.println("blockingQueue.remove(4) = " + blockingQueue.remove());

    }
}
