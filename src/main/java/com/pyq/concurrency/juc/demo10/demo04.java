package com.pyq.concurrency.juc.demo10;

import java.util.function.Supplier;

/**
 * Consumer 只有传入参入 没有返回值
 *
 * @author Yangqi.Pang
 * @date 2020-06-09 14:16
 */
public class demo04 {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "savfsfafa";
        System.out.println(supplier.get());
    }
}
