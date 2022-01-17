package com.multiThread.old;

public class Return1 {
    /**
     * 如何拿到run方法返回值？
     * 1. 主线程等待
     * 2. 通过 Thread.join 等待子线程返回
     */
    static class MyThread implements Runnable {
        private static String value;
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("i = " + (i + 1));
            }

            value = "I have data now";
        }
    }

    public static void main(String[] args) throws Exception{
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();
//        if (MyThread.value == null) {
//            Thread.sleep(100);
//        }
        thread.join(); // 通过join方法等待子线程返回
        System.out.println(MyThread.value);
    }
}
