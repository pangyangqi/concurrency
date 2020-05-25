package com.pyq.concurrency.jvm;

/**
 * @author Yangqi.Pang
 * @date 2020-03-24 17:16
 */
public class Test {
    public static void main(String[] args) {
        ClassLoader classLoader = Test.class.getClassLoader();
        ClassLoader parent = classLoader.getParent();
        ClassLoader parent1 = classLoader.getParent();
        System.out.println(classLoader);
        System.out.println(parent);
        System.out.println(parent1);
    }
}
