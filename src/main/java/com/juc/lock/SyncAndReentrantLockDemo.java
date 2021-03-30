package com.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData2 {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    // A:1 B:2 C:3
    public void print5(){
        lock.lock();
        try {
            // 判断
            while (number != 1) c1.await();
            // 干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 通知
            number = 2; // 通知2号线程，精准通知
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    // A:1 B:2 C:3
    public void print10(){
        lock.lock();
        try {
            while (number != 2) c2.await();
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    // A:1 B:2 C:3
    public void print15(){
        lock.lock();
        try {
            // 判断
            while (number != 3)  c3.await();
            // 干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareData2 data = new ShareData2();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.print5();
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.print10();
            }
        }, "B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.print15();
            }
        }, "C").start();
    }
}
