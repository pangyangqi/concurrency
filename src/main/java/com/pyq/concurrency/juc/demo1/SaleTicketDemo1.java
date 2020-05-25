package com.pyq.concurrency.juc.demo1;

/**
 * Synchronized 和 Lock 的区别
 * 1.Synchronized 是java中的关键字  Lock是一个类
 * 2.Synchronize不可判断 获取锁的状态 Lock 可以判断 获取锁的状态 lock.tryLock();
 * 3.Synchronized适合锁少量的代码块   Lock适合锁大量的同步代码块
 * 4.Synchronized会自动释放锁        Lock不会自动释放锁 必须手动释放，否则会造成死锁现象 并且是成对出现
 * 5.Synchronized是非公锁            Lock默认是非公锁 可以去设置  通过构造去设置
 * 6.Synchronized是阻塞的           Lock就不一定等待下去
 *
 *
 * @author Yangqi.Pang
 * @date 2020-05-24 17:34
 */
public class SaleTicketDemo1 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
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
class Ticket{
    private int number =  100;

    public synchronized void sale(){
        if(number > 0){
            System.out.println(Thread.currentThread().getName() +
                    "卖第"+(number--)+"张票,剩余"+number+"张票");
        }
    }

}
