package com.juc.volati.singleton;

public class Singleton1 {
    /**
     * 饿汉模式，立即实例化
     * 会造成资源浪费
     */
    private static Singleton1 ins = new Singleton1();
    private Singleton1(){}

    public static Singleton1 getIns() {
        return ins;
    }


}
