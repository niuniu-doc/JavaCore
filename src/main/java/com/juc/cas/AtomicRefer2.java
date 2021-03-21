package com.juc.cas;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicRefer2 {
    static AtomicReference<Integer> reference = new AtomicReference<>(5);
    static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(5, 1);

    public static void main(String[] args) {
        new Thread(()->{
            reference.compareAndSet(5, 6);
            reference.compareAndSet(6, 5);
        }, "t1").start();

        new Thread(()->{
            try {Thread.sleep(200);} catch (Exception e){}
            reference.compareAndSet(5,6);
            System.out.println(reference.get());
        }, "t2").start();

        /* ========== 以上是ABA问题的产生，下边是ABA问题的解决 */

        new Thread(() -> {
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + " first version " + stamp);
        }, "t3").start();
    }
}
