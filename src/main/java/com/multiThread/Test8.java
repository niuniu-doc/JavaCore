package com.multiThread;

/**
 * @author nj
 * @date 2022/1/17 6:04 PM
 * 守护线程是一种特殊线程, 进程中没有非守护线程时, 守护线程自动销毁
 * 作用是为其它线程提供便利，最典型的是gc线程
 **/
public class Test8 {
    public static void main(String[] args) throws Exception{
        ThreadF t = new ThreadF();
        t.setDaemon(true);
        t.start();
        Thread.sleep(5000);
        System.out.println("main sleep, daemon not run.");
    }
}

class ThreadF extends Thread {
    private int i = 0;
    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                i++;
                System.out.println("i = " + (i));
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            // ignore
        }
    }
}
