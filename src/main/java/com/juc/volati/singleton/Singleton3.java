package com.juc.volati.singleton;

public class Singleton3 {
    // 此处不加volatile，可能会出现 instance != null,但还未完成初始化的情况
    // memory = allocate, instance(memory) 初始化对象, instance = memory 设置引用关系
    // 地址非空，但地址内容为空
    private static volatile Singleton3 instance = null;
    private Singleton3() {
        System.out.println("construct.");
    }

    public static Singleton3 getInstance() {
        /**
         * DCL Double check lock
         * 必须要使用volatile修饰，保证不发生指令重排
         */
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton3 singleton3 = new Singleton3();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                singleton3.getInstance();
            }).start();
        }
    }
}
