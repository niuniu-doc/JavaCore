package com.multiThread.core;

/**
 * 1. 线程调用具有随机性
 * 2. 先调用start不一定先运行, start 只是告诉线程规划器此线程已经准备就绪, 可以运行
 * 
 */
public class Test1 {
    public static void main(String[] args) {
//        ThreadT t = new ThreadT();
//        t.start();
//        System.out.println("thread run end.");

        ThreadT t = new ThreadT();
        t.setName("ThreadT");
        t.start();
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int)Math.random()*1000;
                Thread.sleep(time);
                System.out.println("main = " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadT extends Thread {
    @Override
    public void run() {
//        System.out.println("Thread T");
        try {
            for (int i=0; i<10; i++) {
                int time = (int)Math.random() * 1000;
                Thread.sleep(time);
                System.out.println("run = " + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
