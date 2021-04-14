package com.juc.thread;

public class SerialTest {
    public static void main(String[] args) {
       concurrency();
        System.out.println();
        serial();
    }

    // 测试并发执行
    public static void concurrency() {
        long start = System.currentTimeMillis();

        new Thread(()->{
            int a = 0;
            for (int i = 0; i < 100000000; i++) {
                a+=5;
            }
            System.out.println( "a = " + a);
        }).start();
        new Thread(()->{
            int count = 100000000;
            for (int i = 0; i < count; i++) {
                count--;
            }
            System.out.println( "count = " + count);
        }).start();
        System.out.println("concurrency time: " + (System.currentTimeMillis() - start));
    }

    // 测试串行执行
    public static void serial() {
        long start = System.currentTimeMillis();
        int count = 100000000;
        int a = 0;
        for (int i = 0; i < count; i++) {
            a += 5;
        }
        for (int j = 0; j < count; j++) {
            count--;
        }
        System.out.println("searial time: " + (System.currentTimeMillis() - start) + " a = " + a + ", count = " + count);
    }
}
