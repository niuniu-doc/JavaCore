package com.multiThread.imooc.test03;

public class Visiable implements Runnable{
    public volatile boolean flag = false;
    public static Object o;

    @Override
    public void run() {
        while (true) {
            if (flag) {
                System.out.println(Thread.currentThread().getName() + " flag is " + flag);
            }
        }
    }
}
