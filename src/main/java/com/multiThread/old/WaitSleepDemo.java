package com.multiThread.old;

public class WaitSleepDemo {
    public static void main(String[] args) {
        /**
         * lock.wait 会释放锁对象，并让出cpu
         * Thread.sleep 只让出cpu，不释放锁对象
         */
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A thread is waiting to get lock.");
                synchronized (lock) {
                    try {
                        System.out.println("thread A get lock.");
                        Thread.sleep(20);
                        System.out.println("thread A do wait method.");
                        lock.wait(3000);
                        System.out.println("thread A is done.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread B waiting for get lock.");
                synchronized (lock) {
                    try {
                        System.out.println("thread B get lock");
                        Thread.sleep(20);
                        System.out.println("thread B do sleep method.");
                        Thread.sleep(20);
                        System.out.println("thread B is done.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
