package com.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData {
    private int number;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        // 判断
        try {
            while (number != 0) {
                condition.await(); // 等待、不能生产
            }
            number++; // 干活
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 通知唤醒
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception {
        lock.lock();
        // 判断
        try {
            while (number == 0) {
                condition.await(); // 等待、不能生产
            }
            number--; // 干活
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 通知唤醒
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class ProdConsumer_TraditionalDemo {
    public static void main(String[] args) {
        ShareData data = new ShareData();

        new Thread(()->{
            try {
                for (int i = 0; i < 5; i++) {
                    data.increment();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "AAA").start();

        new Thread(()->{
            try {
                for (int i = 0; i < 5; i++) {
                    data.decrement();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "BBB").start();
    }
}
