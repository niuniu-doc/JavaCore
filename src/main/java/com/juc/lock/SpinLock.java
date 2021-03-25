package com.juc.lock;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
    AtomicReference<Thread> reference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " come in...");
        while (!reference.compareAndSet(null, thread)) {
            // 若当前线程不为空，不是第一个线程，循环等待
        }
    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        reference.compareAndSet(thread, null); // 只解锁自己的
        System.out.println(thread.getName() + " go out ...");
    }
    public static void main(String[] args) {
        SpinLock lock = new SpinLock();
        new Thread(() -> {
            lock.myLock();
            try {
                Thread.sleep(5000);
            } catch (Exception e) {}
            lock.myUnLock();
        }, "AA").start();

        new Thread(() -> {
            lock.myLock();
            lock.myUnLock();
        }, "BB").start();
    }
}
