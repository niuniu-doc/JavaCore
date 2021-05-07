package com.multiThread;

public class Test11 extends Thread{
    @Override
    public void run() {
        super.run();

        try {
            System.out.println("run begin.");
            Thread.sleep(2000);
            System.out.println("run end.");
        } catch (InterruptedException e) {
            // 在sleep状态下停止某一线程，会进入catch语句，并且清除停止状态值，使之变成false
            System.out.println(" interrupted in sleep, going catch..." + this.isInterrupted());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Test11 thread = new Test11();
            thread.start();
            Thread.sleep(200);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch.");
            e.printStackTrace();
        }
    }
}
