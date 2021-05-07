package com.jvm.byteCode;

public class DeadThreadTest {
    public static void main(String[] args) {
        Runnable r = ()->{
            System.out.println(Thread.currentThread().getName() + " start....");
            DeadThread deadThread = new DeadThread();
            System.out.println(Thread.currentThread().getName() + " end....");
        };
        Thread t1 = new Thread(r, "t1");
        Thread t2 = new Thread(r, "t2");

        t1.start();
        t2.start();
    }


}

class DeadThread {
    // 只会被初始化一次
    static {
        if (true) {
            System.out.println(Thread.currentThread().getName() + " init deadThread....");
            while (true) {}
        }
    }
}
