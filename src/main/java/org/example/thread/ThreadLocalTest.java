package org.example.thread;

public class ThreadLocalTest {
    protected static ThreadLocal local = new ThreadLocal();

    public static void main(String[] args) throws InterruptedException{
        Thread child = new Thread() {
            @Override
            public void run() {
                System.out.println("child init : " + local.get());
                local.set(200);
                System.out.println("child final: " + local.get());
            }
        };
        local.set(100);
        child.start();
        child.join();
        System.out.println(local.get());
    }
}
