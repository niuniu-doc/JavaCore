package com.juc.volati.singleton;

public class Singleton2 {
    /**
     * 懒汉模式，使用的时候才实例化
     */
    private static Singleton2 ins = null;
    private Singleton2() {
        System.out.println("construct");
    }
    public static synchronized Singleton2 getIns() {
        // 可以通过方法上加 synchronize 来保证线程同步,
        // 但加锁粒度太大，并发性降低，可以用同步代码块
        if (ins == null) ins = new Singleton2();
        return ins;
    }

    public static void main(String[] args) {
        Singleton2 singleton2 = new Singleton2();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                singleton2.getIns();
            }).start();
        }
    }
}
