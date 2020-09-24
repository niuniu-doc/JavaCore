package com.ds.queue.ArrayQueue;

public class TestArrayQueue {
    public static void main(String[] args) throws Exception{
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
            if (i % 3 == 2) {
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }
    }
}
