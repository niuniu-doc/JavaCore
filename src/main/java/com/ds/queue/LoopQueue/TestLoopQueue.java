package com.ds.queue.LoopQueue;

public class TestLoopQueue {
    public static void main(String[] args) throws Exception{
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println("en: " + loopQueue);

            if (i % 3 == 2) {
                loopQueue.dequeue();
                System.out.println("de: " + loopQueue);
            }
        }
    }
}
