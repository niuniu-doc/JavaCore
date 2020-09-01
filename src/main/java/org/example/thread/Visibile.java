package org.example.thread;

public class Visibile {
    private static boolean shutdown = false;

    static class HelloThread extends Thread {
        @Override
        public void run() {
            while (!shutdown) {
                System.out.println("time : " + System.currentTimeMillis());
            }
            System.out.println("exit hello");
        }
    }

    public static void main(String[] args) throws Exception{
        new HelloThread().start();
        Thread.sleep(10);
        shutdown = true;
        System.out.println("exit main");
    }
}
