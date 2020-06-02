package com.pyq.concurrency.juc.demo4;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @author Yangqi.Pang
 * @date 2020-05-25 14:10
 */
public class ListTest {


    public static void main(String[] args) {

//        List<String> list = new Vector<>();
//        Collection<Object> list = Collections.synchronizedCollection(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
