package com.pyq.concurrency.juc.demo10;

import java.util.function.Consumer;

/**
 * Consumer 只有传入参入 没有返回值
 *
 * @author Yangqi.Pang
 * @date 2020-06-09 14:16
 */
public class demo03 {
    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;
        consumer.accept("1312421");
    }
}
