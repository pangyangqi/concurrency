package com.pyq.concurrency.juc.demo15;

/**
 * @author Yangqi.Pang
 * @date 2020-06-13 22:40
 */
public class HungrySingle {

    private HungrySingle(){

    }

    private byte[] data1 = new byte[1024*1024];
    private byte[] data2 = new byte[1024*1024];
    private byte[] data3 = new byte[1024*1024];
    private byte[] data4 = new byte[1024*1024];

    private static HungrySingle hungrySingle = new HungrySingle();

    public static HungrySingle getInstance(){
        return hungrySingle;
    }

}
class Test{
    public static void main(String[] args) {
        System.out.println("HungrySingle.getInstance() = " + HungrySingle.getInstance());
        System.out.println("HungrySingle.getInstance() = " + HungrySingle.getInstance());
    }
}
