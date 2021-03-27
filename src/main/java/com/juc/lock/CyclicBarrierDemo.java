package com.juc.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    /**
     * 等待第n个线程到达
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        CyclicBarrier barrier = new CyclicBarrier(7, ()->{
            System.out.println("wait n threads. ");
        });

        for (int i=0; i<7; i++){
            final int tmp = i;
            new Thread(()->{
                System.out.println("get " + tmp + " threads.");
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
