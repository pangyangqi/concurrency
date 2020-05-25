package com.pyq.concurrency.chapter1;

/**
 * @author Yangqi.Pang
 * @date 2020-03-17 21:23
 */
public class ThreadLocalTest {
    static ThreadLocal<String> localVariable = new ThreadLocal<>();
    static void print(String str){
        System.out.println(str + ":" + localVariable.get());
//        localVariable.remove();
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("thread1 local variable");
                print("thread1");
                System.out.println("thread1 remove after:"+localVariable.get());
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("thread2 local variable");
                print("thread2");
                System.out.println("thread2 remove after:"+localVariable.get());
            }
        });
        thread1.start();
        thread2.start();
    }
}
