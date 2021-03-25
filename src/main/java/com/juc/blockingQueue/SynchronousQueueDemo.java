package com.juc.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
    // 每一个put队列必须等待一个take操作
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " put 1");
                blockingQueue.put("1");

                System.out.println(Thread.currentThread().getName() + " put 2");
                blockingQueue.put("2");

                System.out.println(Thread.currentThread().getName() + " put 3");
                blockingQueue.put("3");
            } catch (Exception e) {

            }

        }, "AAA").start();

        new Thread(()->{
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + " take ");
                blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BBB").start();
    }
}
