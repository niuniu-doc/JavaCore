package com.multiThread;

public class Test4 extends Thread{
    public Test4() {
        System.out.println("Test --- begin....");
        System.out.println("Thread.currentThread.getName: " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread.isAlive: " + Thread.currentThread().isAlive());

        System.out.println();
        System.out.println("this.getName: " + this.getName());
        System.out.println("this.getIsAlive: " + this.isAlive());
        System.out.println("Test --- end....");
        System.out.println();
        System.out.println();
    }

    @Override
    public void run() {
        System.out.println("run begin ....");
        System.out.println("Thread.currentThread.getName: " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread.isAlive: " + Thread.currentThread().isAlive());

        // Thread.currentThread 指的是被哪个线程调用，指向外部对象，this指的是当前线程、指向内部对象
        System.out.println();
        System.out.println("this.getName: " + this.getName());
        System.out.println("this.getIsAlive: " + this.isAlive());
        System.out.println("run end ....");
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        Thread thread = new Thread(test4);
        System.out.println("main begin, t1 is Alive：" + thread.isAlive());
        thread.setName("t1");
        thread.start();
        System.out.println("main end, t1 is Alive: " + thread.isAlive());
    }
}
