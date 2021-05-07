package com.multiThread;

/**
 * 数据不共享的情况
 */
public class Test1 extends Thread {
    private int count = 5;
    Test1(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count>0) {
            count--;
            System.out.println("由 " + Thread.currentThread().getName() + " 运算，count = " + count);
        }
    }

    public static void main(String[] args) {
        Test1 t1 = new Test1("t1");
        Test1 t2 = new Test1("t2");
        Test1 t3 = new Test1("t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
