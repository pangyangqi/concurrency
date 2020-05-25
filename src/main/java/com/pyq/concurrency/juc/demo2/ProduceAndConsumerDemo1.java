package com.pyq.concurrency.juc.demo2;

/**
 * 注意虚假唤醒
 *
 *
 *
 * @author Yangqi.Pang
 * @date 2020-05-24 18:10
 */
public class ProduceAndConsumerDemo1 {

    public static void main(String[] args) {
        Data data = new Data();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();


    }


}
class Data{
    private int number = 0;

    public synchronized void increment() throws InterruptedException {
        while (number!=0){
            this.wait();
        }
            number++;
            System.out.println(Thread.currentThread().getName() + "=>" +number);
            this.notifyAll();

    }


    public synchronized void decrement() throws InterruptedException {
        while (number==0){
            this.wait();
        }
            number--;
            System.out.println(Thread.currentThread().getName() + "=>" +number);
            this.notifyAll();
    }
}
