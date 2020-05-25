package com.pyq.concurrency.juc.demo2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition 精准的通知和唤醒线程
 *
 * @author Yangqi.Pang
 * @date 2020-05-24 18:10
 */
public class ProduceAndConsumerDemo3 {


    public static void main(String[] args) {
        Data3 data = new Data3();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    data.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    data.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    data.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();


    }


}

class Data3 {
    private int number = 1;
    private final Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void printA() throws InterruptedException {
        lock.lock();


        try {
            while (number != 1) {
                condition1.await();
            }
                number=2;
                System.out.println(Thread.currentThread().getName() + "=>" + "AA");
            condition2.signal();
        }finally {
            lock.unlock();
        }
    }


    public  void printB() throws InterruptedException {
        lock.lock();
        try{
            while (number != 2) {
                condition2.await();
            }
            number=3;
            System.out.println(Thread.currentThread().getName() + "=>" + "BB");
            condition3.signal();
        }finally {
            lock.unlock();
        }

    }


    public  void printC() throws InterruptedException {
        lock.lock();
        try{
            while (number != 3) {
                condition3.await();
            }
            number = 1;
            System.out.println(Thread.currentThread().getName() + "=>" + "CC");
            condition1.signal();
        }finally {
            lock.unlock();
        }

    }
}
