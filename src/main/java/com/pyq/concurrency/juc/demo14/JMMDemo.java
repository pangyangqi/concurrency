package com.pyq.concurrency.juc.demo14;

import java.util.concurrent.TimeUnit;

/**
 * @author Yangqi.Pang
 * @date 2020-06-13 22:05
 */
public class JMMDemo {
    public volatile static int num = 0;

    public static void main(String[] args) {

        new Thread(()->{
            while (num == 0){

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num = 1;
        System.out.println(num);

    }
}
