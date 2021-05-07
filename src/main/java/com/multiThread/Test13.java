package com.multiThread;

public class Test13 extends Thread{
    @Override
    public void run() {
        while (true) {
            if (this.isInterrupted()) {
                System.out.println("stop");
                return; // 虽然return可以实现线程的停止，还是建议使用抛异常的方式，手动处理
            }
            System.out.println("timer= " + System.currentTimeMillis());
        }
    }

    /**
     * 使用return停止线程
     */
    public static void main(String[] args) throws InterruptedException{
        Test13 thread = new Test13();
        thread.start();;
        Thread.sleep(20);
        thread.interrupt();
    }
}
