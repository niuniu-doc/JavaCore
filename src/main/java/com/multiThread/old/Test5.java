package com.multiThread.old;

public class Test5 extends Thread {
    @Override
    public void run() {
        System.out.println("run threadName = " + Thread.currentThread().getName() + " begin");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("run threadName = " + Thread.currentThread().getName() + " end");
    }

    public static void main(String[] args) {
        Test5 myThread = new Test5();
        System.out.println("begin = " + System.currentTimeMillis());
        myThread.start(); // start 是异步通知线程组，线程可以被调度，run是直接启动一个线程
        System.out.println("end = " + System.currentTimeMillis());
    }
}
