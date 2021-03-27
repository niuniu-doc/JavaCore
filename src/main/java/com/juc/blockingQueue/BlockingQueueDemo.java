package com.juc.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3); // 将队列大小初始化为10
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.element());
//        // 超出queue容量，Exception in thread "main" java.lang.IllegalStateException: Queue full
//        System.out.println(blockingQueue.add("d"));


//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("b"));
//        System.out.println(blockingQueue.offer("c"));
//        System.out.println(blockingQueue.offer("d"));
//        System.out.println(blockingQueue.peek());

//        blockingQueue.put("a");
//        blockingQueue.put("b");
//        blockingQueue.put("c");
//        blockingQueue.put("d");

        blockingQueue.offer("a", 2, TimeUnit.SECONDS);
        blockingQueue.offer("b", 2, TimeUnit.SECONDS);
        blockingQueue.offer("c", 2, TimeUnit.SECONDS);
        blockingQueue.offer("d", 2, TimeUnit.SECONDS);
    }
}
