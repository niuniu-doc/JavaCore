package org.example.concurrent;

public class VolatileExample {
    int x = 0;
    volatile boolean v = false;

    public void writer() {
        x = 42;
        v = true;
    }

    public void reader() {
        System.out.println(v);
        if (v) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            VolatileExample e = new VolatileExample();
            e.writer();
            e.reader();
        });
        Thread t2 = new Thread(()->{
            VolatileExample e = new VolatileExample();
            e.writer();
            e.reader();
        });
        t1.start();
        t2.start();

        int cnt = 10;

        Thread t = new Thread(()-> System.out.println(cnt));
        cnt = 7;
        t.start();

    }
}
