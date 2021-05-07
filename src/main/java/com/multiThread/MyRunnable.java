package com.multiThread;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("running...");
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable, "r1");
        thread.start();
        System.out.println("run end..." + " thread name : " + Thread.currentThread().getName());
    }
}
