package com.pyq.concurrency.juc.demo3;

import java.util.concurrent.TimeUnit;

/**
 *
 * 1、标准情况下，两个线程先打印 发短信还是 打电话？ 1/发短信 2/打电话
 * 2、sendSms延迟4秒，两个线程先打印 发短信还是 打电话？ 1/发短信 2/打电话
 *
 * @author Yangqi.Pang
 * @date 2020-05-25 08:11
 */
public class Test1 {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(phone::sendMs,"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(phone::call,"B").start();
    }
}

/**
 * Synchronized 锁的对象是方法的调用者
 * 两个方法是同一把锁 谁先拿到谁先执行
 */
class Phone{

    public synchronized void sendMs(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }
}
