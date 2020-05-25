package com.pyq.concurrency.chapter2;

import org.apache.tomcat.jni.Error;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Yangqi.Pang
 * @date 2020-03-18 08:02
 */
public class UnSafeTest {
    static  Unsafe unsafe;
    static  long stateOffset = 0;
    private volatile long state = 0;
    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            stateOffset = unsafe.objectFieldOffset(UnSafeTest.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static void main(String[] args) {
        UnSafeTest unSafeTest = new UnSafeTest();
        unsafe.compareAndSwapInt(unSafeTest,stateOffset,0,4);
        System.out.println(unSafeTest.state);
        System.out.println("success");
    }
}
