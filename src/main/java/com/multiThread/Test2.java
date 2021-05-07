package com.multiThread;

/**
 * 共享数据的情况
 */
public class Test2 extends Thread{
    private int count = 5; //

    @Override
    public synchronized void run() { // 若不加 synchronized 会出现多线程并发修改数据的情况
        super.run();
        count--;
        System.out.println(Thread.currentThread().getName() + " 计算， count = " + count);
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();

        Thread t1 = new Thread(test2, "A");
        Thread t2 = new Thread(test2, "B");
        Thread t3 = new Thread(test2, "C");
        Thread t4 = new Thread(test2, "D");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
