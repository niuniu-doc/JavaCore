package com.juc.volati;

import java.util.concurrent.atomic.AtomicInteger;

public class Automic {
    static class MyData {
        private volatile int number = 0; // 此时number有volatile修饰，但不保证原子性
        public synchronized void addPlusPlus () { // 使用synchronize可以保证原子性
            number++;
        }

        private AtomicInteger atomicInteger = new AtomicInteger(0);
        public void addAtomic() {
            atomicInteger.getAndIncrement();
        }
    }
    public static void main(String[] args) {
        MyData myData = new MyData();
        for (int i = 0; i < 20 ; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2 ) {
            Thread.yield(); // 若活跃线程数大于2，则等待
        }

        System.out.println(myData.number);
        System.out.println(myData.atomicInteger);
    }
}
