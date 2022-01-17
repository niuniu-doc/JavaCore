package com.multiThread.old;

public class MyThread extends Thread{
    private int i;
    public MyThread(int i) {
        super();
        this.i = i;
    }
    @Override
    public void run() {
        System.out.println(i);
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread(2);
        myThread.start();

        MyThread myThread1 = new MyThread(1);
        myThread1.start();

    }
}
