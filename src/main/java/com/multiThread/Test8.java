package com.multiThread;

public class Test8 extends Thread{
    /**
     * this.interrupted() 测试当前线程是否已中断, 同时清除中断标志位
     * this.isInterrupted() 测试线程是否已中断，不清除中断标志位
     */
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 50; i++) {
            System.out.println("i = " + (i + 1));
        }
    }

    public static void main(String[] args) throws Exception{
        Test8 thread = new Test8();
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        // thread.interrupted 代表的是当前线程，这个当前线程代表的是 main，从未停止过，所以是 false
//        System.out.println("stop ? " + Thread.interrupted());
//        System.out.println("stop ? " + thread.interrupted());

        System.out.println("stop thead ? " + thread.isInterrupted());
        System.out.println("stop thread ? " + thread.isInterrupted());
        System.out.println("end");
    }
}
