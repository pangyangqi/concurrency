package com.pyq.concurrency.juc.demo10;

import java.util.function.Function;

/**
 * Function 函数型接口, 有一个输入参数，有一个输出
 *
 * @author Yangqi.Pang
 * @date 2020-06-09 14:16
 */
public class demo01 {
    public static void main(String[] args) {
        Function<String,String> function = s -> s;
        System.out.println(function.apply("sdgsdgdsg"));
    }
}
