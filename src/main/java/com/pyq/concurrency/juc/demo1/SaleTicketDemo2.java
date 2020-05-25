package com.pyq.concurrency.juc.demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Yangqi.Pang
 * @date 2020-05-24 17:34
 */
public class SaleTicketDemo2 {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();
        new Thread(()->{
            for (int i = 1; i <= 100; i++) {
                ticket.sale();
            }
        },"a").start();

        new Thread(()->{
            for (int i = 1; i <= 100; i++) {
                ticket.sale();
            }
        },"b").start();

        new Thread(()->{
            for (int i = 1; i <= 100; i++) {
                ticket.sale();
            }
        },"c").start();
    }

}

class Ticket2{
    private int number =  100;
    Lock lock = new ReentrantLock(true);
//    Lock lock = new ReentrantLock();默认非公平锁

    public void sale(){
        lock.lock();
        lock.tryLock();
        try{
        if(number > 0){
            System.out.println(Thread.currentThread().getName() +
                    "卖第"+(number--)+"张票,剩余"+number+"张票");
        }
        }finally {
            lock.unlock();
        }
    }

}
