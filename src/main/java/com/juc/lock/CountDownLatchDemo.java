package com.juc.lock;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception{
        /**
         * CountDownLatch 是一直等到所有线程执行完成，累减操作
         * CyclicBarrier 是一直等到所有线程到达，累加操作
         * Semaphore 是保持n个变量
         */
        CountDownLatch countDownLatch = new CountDownLatch(6); // 计数类
//        for (int i = 0; i < 6; i++) {
//            new Thread(() -> {
//                System.out.println(Thread.currentThread().getName() + " go  away.");
//                countDownLatch.countDown();
//            }, String.valueOf(i)).start();
//        }
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " go  away.");
                countDownLatch.countDown();
            }, Objects.requireNonNull(CountryEnum.forEach_CountryEnum(i)).getRetMsg()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " close the door.");
    }
}
