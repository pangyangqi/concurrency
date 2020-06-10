package com.pyq.concurrency.juc.demo10;

import java.util.function.Predicate;

/**
 * Predicate 断定型接口：有一个输入参数，返回值只能是 布尔值！
 *
 * @author Yangqi.Pang
 * @date 2020-06-09 14:16
 */
public class demo02 {
    public static void main(String[] args) {
        Predicate<String> predicate = a -> a.equals("love");
        System.out.println(predicate.test("12"));
    }
}
