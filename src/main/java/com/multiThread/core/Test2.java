package com.multiThread.core;

/**
 * 非共享变量
 */
public class Test2 {
    public static void main(String[] args) {
        ThreadT2 t1 = new ThreadT2("A");
        ThreadT2 t2 = new ThreadT2("B");
        ThreadT2 t3 = new ThreadT2("C");

        t1.start();
        t2.start();
        t3.start();
    }

}

class ThreadT2 extends Thread {
    private int count = 5;
    ThreadT2(String name) {
       super();
       this.setName(name);
    }
    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由 " + ThreadT.currentThread().getName() + " 计算, count = " + count);
        }
    }
}
