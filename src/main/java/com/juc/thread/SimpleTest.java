package com.juc.thread;

public class SimpleTest {
    public static void main(String[] args) {
        Example example = new Example();
        new Thread(()->{
            example.reader();
        }).start();
        new Thread(()->{
            example.writer();
        }).start();
    }

    static class Example{
        int a = 2;
        boolean flag = false;

        public void writer() {
            System.out.println("writer");
            a=1;
            flag = true;
        }

        public void reader() {
            System.out.println("reader");
            if (flag) {
                System.out.println(" a = " + a + ", flag = " + flag);
            }
        }
    }
}
