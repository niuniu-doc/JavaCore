package org.example.thread;

import java.util.concurrent.CountDownLatch;

public class CountDown {
    static class Racer extends Thread {
        CountDownLatch latch;
        public Racer (CountDownLatch latch) {
            this.latch = latch;
        }
        @Override
        public void run() {
            try {
                this.latch.await();
                System.out.println(getName() + " start run " + System.currentTimeMillis());
            } catch (Exception e) {
                // ignore
            }
        }
    }

    public static void main(String[] args) throws Exception{
        int num = 6;
        CountDownLatch latch = new CountDownLatch(1);

        System.out.println("==" + System.currentTimeMillis());
        Thread[] racers = new Thread[num];
        for (int i = 0; i < num; i++) {
            racers[i] = new Racer(latch);
            racers[i].start();
        }
        Thread.sleep(2000);
        latch.countDown();
        System.out.println(latch.getCount());
    }
}
