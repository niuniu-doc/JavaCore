package org.example.thread;

import java.util.Timer;
import java.util.TimerTask;

public class BasicTimer {
    static class DelayTask extends TimerTask {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
            System.out.println("delayed task.");
        }
    }

    public static void main(String[] args) throws Exception {
        Timer timer = new Timer();
        System.out.println(System.currentTimeMillis());
        timer.schedule(new DelayTask(), 1000);
        System.out.println(System.currentTimeMillis());
        Thread.sleep(2000);
        timer.cancel();
    }
}
