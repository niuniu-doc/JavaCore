package com.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockSupportDemo {
    static Object objectLock = new Object();

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
//        testSynchronizedLock();
        System.out.println();
        testLockCondition();
        System.out.println();
      //  testLockSupport();
    }

    private static void testLockSupport() {
        Thread a  = new Thread(()->{
            try { Thread.sleep(2000); } catch (Exception e) { } //
            System.out.println(Thread.currentThread().getName() + " come in ... " + System.currentTimeMillis());
            LockSupport.park(); // 等待通行证，等待被放行, 若先执行后边儿的unpark、此处的park相当于被直接注释掉
            System.out.println(Thread.currentThread().getName() + " get permit , wakeup ... " + System.currentTimeMillis());
        }, "A");
        a.start();

        new Thread(()-> {
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName() + " send a permit ... " + System.currentTimeMillis());
        }, "B").start();
    }

    private static void testLockCondition() {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " come in ...");
            try { Thread.sleep(2000); } catch (Exception e) { } //
            lock.lock();
            try {
                condition.await();
                System.out.println(Thread.currentThread().getName() + " wake up ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "C").start();

        new Thread(()->{
            lock.lock();
            condition.signal();
            System.out.println(Thread.currentThread().getName() + " send signal ...");
            lock.unlock();
        }, "D").start();
    }

    private static void testSynchronizedLock() {
        new Thread(()->{
            try { Thread.sleep(2000); } catch (Exception e) { } //
            synchronized (objectLock) {
                try {
                    System.out.println(Thread.currentThread().getName() + " come in ...");
                    objectLock.wait();
                    System.out.println(Thread.currentThread().getName() + " wait begin ...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(()->{
            synchronized (objectLock) {
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() + " notify begin ...");
            }
        }, "B").start();
    }
}
