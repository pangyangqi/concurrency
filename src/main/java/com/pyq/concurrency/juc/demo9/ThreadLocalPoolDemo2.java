package com.pyq.concurrency.juc.demo9;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.*;

/**
 * @author Yangqi.Pang
 * @date 2020-06-03 16:35
 */
public class ThreadLocalPoolDemo2 {
    public static void main(String[] args) {

        //作为栈使用
        Deque<Integer> stack=new LinkedList<>();
        System.out.println("栈为空:"+stack.isEmpty());   //判断栈是否为空
        stack.addFirst(12);
        System.out.println("栈为空:"+stack.isEmpty());   //判断栈是否为空
        System.out.println(stack.peekFirst());   //获取栈顶元素
        System.out.println(stack.pollFirst());   //获取并移除栈顶元素
        System.out.println("栈为空:"+stack.isEmpty());   //判断栈是否为空
        System.out.println("============================================");

//        System.out.println("Runtime.getRuntime().availableProcessors() = " + Runtime.getRuntime().availableProcessors());;
//        ExecutorService executorService = new ThreadPoolExecutor(
//                2,//核心线程数
//                5,//最大线程数
//                3,//超时时间
//                TimeUnit.SECONDS,//超时单位
//                new LinkedBlockingQueue<>(1),//阻塞队列
//                Executors.defaultThreadFactory(),//线程工厂
////                new ThreadPoolExecutor.AbortPolicy()//队列满了，抛出异常
////                new ThreadPoolExecutor.CallerRunsPolicy() //队列满了 哪来的回哪去
////                new ThreadPoolExecutor.DiscardOldestPolicy() //队列满了 尝试和最早的竞争
//                new ThreadPoolExecutor.DiscardPolicy()//队列满了 就丢掉任务
//        );
//        try {
//            for (int i = 1; i <= 100; i++) {
//                executorService.execute(() -> {
//                    System.out.println(Thread.currentThread().getName() + " ok");
//                });
//            }
//        }finally {
//            executorService.shutdown();
//        }
    }
}
