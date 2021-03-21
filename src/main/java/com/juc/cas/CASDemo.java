package com.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        atomicInteger.compareAndSet(5, 2021);
        System.out.println("atomicInteger now is: " + atomicInteger.get());
        atomicInteger.compareAndSet(5, 2022); // modify failed
        System.out.println("atomicInteger now is: " + atomicInteger.get());

        atomicInteger.getAndIncrement(); // unsafe类
        /**
         * unsafe.getAndAddInt(this, valueOffset, 1);
         * this 当前对象
         * valueOffset 内存偏移量
         * 底层是通过cas实现的，利用的CPU原语
         */
    }
}
