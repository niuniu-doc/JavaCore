package com.juc.threadPool;

import java.util.concurrent.*;

public class MyThreadPoolDemo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

        // Array Arrays
        // Collection Collections
        // Executor Executors
        // 后边儿是前边儿对应的工具类
//        ExecutorService threadPool1 = Executors.newFixedThreadPool(2); // 一池固定线程数
//        ExecutorService threadPool = Executors.newCachedThreadPool(); // 一池固定线程数
//        // 模拟10个用户办理业务
//        try {
//            for (int i = 0; i < 10; i++) {
//                threadPool.execute(()->{
//                    System.out.println(Thread.currentThread().getName() + " 开始执行任务");
//                });
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            threadPool.shutdown();
//        }

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        try {
            // 模拟10个用户办理业务
            for (int i = 0; i < 9; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + " 执行任务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
