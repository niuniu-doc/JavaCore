package com.juc.lock;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception{

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
