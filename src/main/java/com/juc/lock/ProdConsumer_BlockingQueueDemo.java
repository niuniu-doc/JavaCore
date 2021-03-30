package com.juc.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData {
    private volatile Boolean flag = true; // 默认开启，进行生产和消费
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null; // 不指定具体类，保留扩展性
    public MyData(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception {
        String data = null;
        Boolean retValue = null;
        while (flag) {
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + " 插入队列成功");
            } else {
                System.out.println(Thread.currentThread().getName() + " 插入队列失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + " 不再继续插入数据");
    }

    public void myConsume() throws Exception {
        String retValue = null;
        while (flag) {
            retValue = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (retValue == null || retValue.equalsIgnoreCase(" ")) {
                flag = false;
                System.out.println(Thread.currentThread().getName() + " 超过2s没有取到数据，消费退出.");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName() + " 消费队列成功");
            System.out.println();
            System.out.println();
        }
    }

    public void stop() {
        this.flag = false;
    }
}
// volatile / cas / atomic / blockingQueue / 线程交互 / 原子引用
public class ProdConsumer_BlockingQueueDemo {
    public static void main(String[] args) throws Exception{
        MyData myData = new MyData(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            try {
                myData.myProd();
            } catch (Exception e) {}
        }, "A").start();

        new Thread(()->{
            try {
                myData.myConsume();
            } catch (Exception e) {}
        }, "B").start();

        TimeUnit.SECONDS.sleep(3);

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(" 活动结束");
        myData.stop();
    }
}
