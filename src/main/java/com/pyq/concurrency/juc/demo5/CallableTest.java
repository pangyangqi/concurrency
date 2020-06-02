package com.pyq.concurrency.juc.demo5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 *
 * FutureTask结果会被缓存
 *
 * 结果可能需要等待 会阻塞
 *
 * @author Yangqi.Pang
 * @date 2020-05-25 20:50
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(myThread);

        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();

        TimeUnit.SECONDS.sleep(2);
        new Thread(futureTask,"C").start();

        System.out.println("futureTask.get() = " + futureTask.get());;
    }

}
class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("调用call");
        return 123456;
    }
}
