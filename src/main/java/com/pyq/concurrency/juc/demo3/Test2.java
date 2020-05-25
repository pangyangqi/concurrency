package com.pyq.concurrency.juc.demo3;

import java.util.concurrent.TimeUnit;

/**
 *
 * 3、 增加了一个普通方法后！先执行发短信还是Hello？ 普通方法
 * 4、 两个对象，两个同步方法， 发短信还是 打电话？ // 打电话
 *
 * @author Yangqi.Pang
 * @date 2020-05-25 08:11
 */
public class Test2 {
    public static void main(String[] args) {
        //两个对象两把锁
        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();

        new Thread(phone1::sendMs,"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(phone2::call,"B").start();
    }
}

/**
 * Synchronized 锁的对象是方法的调用者
 * 两个方法是同一把锁 谁先拿到谁先执行
 */
class Phone2{

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

    public void hello(){
        System.out.println("hello");
    }
}
