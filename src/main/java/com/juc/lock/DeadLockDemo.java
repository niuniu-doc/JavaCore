package com.juc.lock;

import java.util.concurrent.TimeUnit;

class HoldLockThread implements Runnable{
    private String LockA;
    private String LockB;
    HoldLockThread(String lockA, String lockB) {
        this.LockA = lockA;
        this.LockB = lockB;
    }

    @Override
    public void run() {
        synchronized (LockA) {
            System.out.println(Thread.currentThread().getName() + " 持有锁 " + LockA + ", 试图获取锁 " + LockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (LockB) {
                System.out.println(Thread.currentThread().getName() + " 持有锁 " + LockB + ", 试图获取锁 " + LockA);
            }
        }
    }
}
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA, lockB), "AAA").start();
        new Thread(new HoldLockThread(lockB, lockA), "BBB").start();
    }
}
