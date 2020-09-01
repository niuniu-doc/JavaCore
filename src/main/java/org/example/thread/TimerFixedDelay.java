package org.example.thread;

import java.util.Timer;
import java.util.TimerTask;

public class TimerFixedDelay {
    static class LongRunningTask extends TimerTask {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                // ignore
            }
        }
    }

    static class fixedDelayTask extends TimerTask {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new LongRunningTask(), 10);
        timer.schedule(new fixedDelayTask(), 10, 1000);
    }
}
