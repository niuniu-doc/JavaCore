package com.juc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Simple {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        /**
         * 模拟银行顾客办理业务
         * 3个线程模拟3个来银行办理业务的顾客
         * 假设A顾客办理时间很长
         */
        new Thread(()->{
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " come in.");
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " done.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "A").start();

        // 只有一个窗口、B、C顾客进入等待
        new Thread(()->{
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " come in. ");
            lock.unlock();
        }, "B").start();

        new Thread(()->{
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " come in. ");
            lock.unlock();
        }, "C").start();
    }
}
