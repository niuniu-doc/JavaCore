package com.multiThread.imooc.test03;

import com.juc.volati.Automic;

public class DeadLockDemo {
    private final String readLock = new String();
    private final String writeLock = new String();

    public void writeLock() {
        synchronized (writeLock) {
            System.out.println(Thread.currentThread().getName() + " get writeLock, and wait for read lock. ");
            synchronized (readLock) {
                System.out.println(Thread.currentThread().getName() + " get read lock. ");
            }
        }
    }

    public void readLock() {
        synchronized (readLock) {
            System.out.println(Thread.currentThread().getName() + " get readLock, and wait for writeLock. ");
            synchronized (writeLock) {
                System.out.println(Thread.currentThread().getName() + " get writeLock");
            }
        }
    }

    public static void main(String[] args) {

        DeadLockDemo deadLock = new DeadLockDemo();
        new Thread(() -> {
            while (true) {
                deadLock.readLock();
            }
        }, "read thread").start();

        new Thread(()->{
            while (true) {
                deadLock.writeLock();
            }
        }, "write thread").start();
    }
}
