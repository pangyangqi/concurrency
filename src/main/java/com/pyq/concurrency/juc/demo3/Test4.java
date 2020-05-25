package com.pyq.concurrency.juc.demo3;

import java.util.concurrent.TimeUnit;

/**
 *
 * new this 具体的一个手机static Class 唯一的一个模板
 *
 *
 * 7、1个静态的同步方法，1个普通的同步方法 ，一个对象，先打印 发短信？打电话？
 * 8、1个静态的同步方法，1个普通的同步方法 ，两个对象，先打印 发短信？打电话？
 *
 * @author Yangqi.Pang
 * @date 2020-05-25 08:11
 */
public class Test4 {
    public static void main(String[] args) {
        //两个对象两把锁
        Phone4 phone1 = new Phone4();
        Phone4 phone2 = new Phone4();

        new Thread(()->{
            phone1.sendMs();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone2.call();
        },"B").start();
    }
}

/**
 * Phone3唯一的一个 Class 对象
 * static 静态方法类一加载就有了！锁的是Class
 */
class Phone4{

    public static synchronized void sendMs(){
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
