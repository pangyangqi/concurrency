package com.pyq.concurrency.juc.demo12;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * 求和计算的任务！
 * 3000 6000（ForkJoin） 9000（Stream并行流）
 * // 如何使用 forkjoin
 * // 1、forkjoinPool 通过它来执行
 * // 2、计算任务 forkjoinPool.execute(ForkJoinTask task)
 * // 3. 计算类要继承 ForkJoinTask
 */
public class ForkJoinTest extends RecursiveTask<Long> {
    private Long start; // 1
    private Long end; // 1990900000

    public ForkJoinTest(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    // 临界值
    private Long temp = 10_000_000L;

    @Override
    protected Long compute() {
        if((end - start) <temp){
            Long sum = 0L;
            for (Long i = start; i<=end;i++){
                sum += i;
            }
            return sum;
        }else {
            long middle = (start + end)/2;
            ForkJoinTest forkJoinTest = new ForkJoinTest(start,middle);
            forkJoinTest.fork();
            ForkJoinTest forkJoinTest1 = new ForkJoinTest(middle+1,end);
            forkJoinTest1.fork();
            return forkJoinTest.join() + forkJoinTest1.join();

        }
    }
}
class Test{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test();
        test1();
        test2();
    }

    private static void test2() {
        long start = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(0L,
                10_0000_0000L).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 时间："+(end-start));

    }

    private static void test1() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinTest(0L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        Long sum = submit.get();
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 时间："+(end-start));


    }

    private static void test() {
        Long sum = 0L;
        long start = System.currentTimeMillis();
        for(int i = 1 ; i< 10_0000_0000L;i++){
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum = " + sum + "时间："+(end-start));
    }
}
