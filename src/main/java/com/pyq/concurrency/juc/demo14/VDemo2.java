package com.pyq.concurrency.juc.demo14;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Yangqi.Pang
 * @date 2020-06-13 22:24
 */
public class VDemo2 {
    public volatile static AtomicInteger num = new AtomicInteger(0);

    public static void add(){
        num.getAndIncrement();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for(int j = 0; j<1000;j++){
                    add();
                }
            }).start();
        }

        while (Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + " " +num);
    }



}
