package com.pyq.concurrency.juc.demo4;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Yangqi.Pang
 * @date 2020-05-25 14:10
 */
public class SetTest {


    public static void main(String[] args) {

//        Set<String> set = new HashSet<>();
//        Collection<String> set = Collections.synchronizedCollection(new HashSet<>());
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
