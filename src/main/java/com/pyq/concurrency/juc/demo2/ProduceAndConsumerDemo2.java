package com.pyq.concurrency.juc.demo2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Yangqi.Pang
 * @date 2020-05-24 18:10
 */
public class ProduceAndConsumerDemo2 {


    public static void main(String[] args) {
        Data2 data = new Data2();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();


    }


}

class Data2 {
    private int number = 0;
    private final Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();


        try {
            while (number != 0) {
                condition.await();
            }
                number++;
                System.out.println(Thread.currentThread().getName() + "=>" + number);
                condition.signalAll();
        }finally {
            lock.unlock();
        }
    }


    public  void decrement() throws InterruptedException {
        lock.lock();
        try{
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }
}
