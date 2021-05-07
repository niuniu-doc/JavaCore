package com.multiThread;


public class Test7 extends Thread{
    /**
     * 停止线程可以使用
     * 1. 使用退出标志，使线程正常退出，即：run执行完成、自动终止
     * 2. 使用stop方法强行终止，不推荐，因为stop和suspend及resume都是过期方法
     * 3. 使用interrupt方法中断线程，仅仅是在当前线程中打了一个停止的标记，并不会立即停止线程
     */

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            System.out.println(" i = " + (i + 1));
        }
    }

    public static void main(String[] args) throws Exception{
        Test7 test7 = new Test7();
        test7.start();
        Thread.sleep(2);
        test7.interrupt();
    }
}
