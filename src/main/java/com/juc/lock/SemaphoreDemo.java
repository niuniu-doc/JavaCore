package com.juc.lock;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);// 模拟3个停车位
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                // 模拟6辆车抢3个停车位
                try {
                    semaphore.acquire(); // 抢占资源
                    System.out.println(Thread.currentThread().getName() + "抢到车位");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + "停车3s后离开车位");
                    semaphore.release(); // 释放占用资源
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
