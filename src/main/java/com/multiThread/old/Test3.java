package com.multiThread.old;

import java.util.concurrent.TimeUnit;

/**
 * Thread.isAlive() 检测线程是否处于存活状态，已启动，且未终止
 */
public class Test3 extends Thread{
    @Override
    public void run() {
        System.out.println("run is " + this.isAlive());
    }

    public static void main(String[] args) throws Exception{
        Test3 myThread = new Test3();
        System.out.println("start is " + myThread.isAlive());
        myThread.start(); // 此时thread线程已执行完成、end应该是 false，可以使用等待、让线程设置完状态的方式验证
        TimeUnit.SECONDS.sleep(1);
        System.out.println("end is " + myThread.isAlive());
    }
}
