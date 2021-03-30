package com.juc.threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 实现线程的方式
 * 1. 继承 Runnable 接口
 * 2. new Thread
 * 3. 实现 Callable 接口
 * 4.
 */
class MyThread implements Runnable {
    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " come in future.");
        TimeUnit.SECONDS.sleep(2);
        return 1024;
    }
}
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyThread2());

        new Thread(futureTask, "AAA").start();
        new Thread(futureTask2, "BBB").start(); // 这样只会使用一次future，如果需要两次、要重新构建一个新的future

        // 建议将future.get()放在最后，若未计算完成就去取，会一直阻塞到计算完成
        System.out.println(futureTask.get());

        // 或者使用
        while (!futureTask.isDone()) {

        }
        System.out.println("123");
    }
}
