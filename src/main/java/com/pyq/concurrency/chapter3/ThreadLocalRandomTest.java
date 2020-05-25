package com.pyq.concurrency.chapter3;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Yangqi.Pang
 * @date 2020-03-23 20:42
 */
public class ThreadLocalRandomTest {
    public static void main(String[] args) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        for(int i=0;i<10;i++){
            System.out.println(threadLocalRandom.nextInt(5));
        }
    }
}
