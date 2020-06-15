package com.pyq.concurrency.juc.demo15;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Yangqi.Pang
 * @date 2020-06-13 22:46
 */
public class LazySingle {
    private LazySingle(){
//        synchronized (LazySingle.class){
//            throw new RuntimeException("不要试图使用反射破坏异常");
//        }
    }

    private static LazySingle lazySingle = null;


    public static LazySingle getInstance(){
        if(lazySingle == null){
            synchronized (LazySingle.class){
                if(lazySingle == null){
                    lazySingle = new LazySingle();
                }
            }
        }
        return lazySingle;
    }

}
class TestLazySingle{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("LazySingle.getInstance() = " + LazySingle.getInstance());

        Constructor<LazySingle> declaredConstructor = LazySingle.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazySingle lazySingle = declaredConstructor.newInstance();

        System.out.println("LazySingle.getInstance() = " + lazySingle);


    }
}
