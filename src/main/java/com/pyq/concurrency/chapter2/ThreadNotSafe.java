package com.pyq.concurrency.chapter2;

/**
 * @author Yangqi.Pang
 * @date 2020-03-18 07:28
 */
public class ThreadNotSafe {
    private Long value;

    public Long getValue(){
        return value;
    }

    public void inc(){
        ++value;
    }
}
