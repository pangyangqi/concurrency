package com.pyq.concurrency.juc;

/**
 * @author Yangqi.Pang
 * @date 2020-05-24 17:29
 */
public class Test1 {
    public static void main(String[] args) {
        //获取cpu的核数
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
