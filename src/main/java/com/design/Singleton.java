package com.design;

import java.io.IOException;
import java.util.Properties;

public class Singleton {
    /**
     * 1. 一个类只能有一个实例  构造器私有化
     * 2. 必须自行创建这个实例  包含一个该类的静态变量来保存该类的实例
     * 3. 必须向整个系统提供该实例
     * 饿汉式：在类初始化时 直接创建对象，不存在线程安全问题
     *   1. 直接实例化饿汉式 简单直接
     *   2. 枚举式 最直接，枚举的作用是限定几个特定的值，限定为一个，就变成了单例
     *   3. 静态代码块饿汉式 适合复杂实例化
     *
     * 懒汉式：延迟创建对象
     *   1. 线程不安全 适用于单线程
     *   2. 线程安全 适用于多线程
     *   3. 静态内部类 适用于多线程
     */
    /**
     * get instance right now
     * mem malloc at first
     * 为了强调这是单例，可以使用final修饰
     */
//    private static final Singleton ins = new Singleton();
//    private Singleton(){}
//    public Singleton getIns() {
//        return ins;
//    }

    private static final Singleton ins;
    private String info;
    static {
        Properties properties = new Properties();
        try {
            properties.load(Singleton.class.getClassLoader().getResourceAsStream("single.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ins = new Singleton(properties.getProperty("info"));
    }
    private Singleton(String info){
        this.info = info;
    }

    /**
     * get instance until get ins
     * mem malloc until use
     * tips: use synchronize, other wise, will get ins more than one
     * Lower efficiency
     */
//    private static Singleton ins = null;
//    private Singleton(){}
//    public synchronized Singleton getIns() {
//        if (ins == null) ins = new Singleton();
//        return ins;
//    }

    /**
     * lock ins
     */
//    private static Singleton ins = null;
//    private Singleton(){}
//    public Singleton getIns() {
//        if (ins == null) { // Double check lock, DCL, avoid lock ins right now, Reduce Competition
//            synchronized (Singleton.class) {
//                if (ins == null) {
//                    ins = new Singleton();
//                }
//            }
//        }
//        return ins;
//    }

    /**
     * static inner class
     * avoid lock competition
     * 在内部类被加载和初始化时，才初始化
     */
    private static class LazyHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton(){}
    public static final Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }

    /**
     * enum
     */
    public enum Single {
        INSTANCE;
    }

}
