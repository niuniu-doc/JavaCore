package com.multiThread.core;

/**
 * 线程间共享变量，会出现多线程同时操作一个值的情况
 * isAlive 判断线程是否处于活动状态
 * sleep 判断线程是否处于休眠状态
 */
public class Test3 {
    public static void main(String[] args) {
        ThreadA t = new ThreadA();
        Thread a = new Thread(t,"A");
        Thread b = new Thread(t,"B");
        Thread c = new Thread(t,"C");
        a.start();
        b.start();
        c.start();
    }
}

/**
 * synchronized 定义临界区，方法或者对象, 临界区内的代码只能有一个(获得锁的那个)线程访问
 * 非线程安全: 多个线程操作同一个对象时, 值不同步的情况
 */
class ThreadA extends Thread {
    private int count = 3;
    @Override
    synchronized public void run() {
        super.run();

        System.out.println("由 " + Thread.currentThread().getName() + " 计算, count = " + count --);
    }
}