package com.juc.lock;

import java.util.concurrent.locks.LockSupport;

public class ReEnterLockDemo {
    private static Object lockA = new Object();

    // 同一个线程可以多次获取同一个对象上的锁，同步代码块
    private static void m1() {
        new Thread(() -> {
            synchronized (lockA) {
                System.out.println("外层锁...");
                synchronized (lockA) { // 再次获取锁 lockA
                    System.out.println("中层锁...");
                    synchronized (lockA) {
                        System.out.println("内层锁...");
                    }
                }
            }
        }, "t1").start();
    }

    private static synchronized void m2() {
        System.out.println("外");
        m3();
    }

    private static synchronized void m3() {
        System.out.println("中");
        m4();
    }

    private static synchronized void m4() {
        System.out.println("内");
    }

    public static void main(String[] args) {
        m1();
        System.out.println();
        m2();
    }
}
