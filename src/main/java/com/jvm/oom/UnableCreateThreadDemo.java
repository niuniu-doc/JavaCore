package com.jvm.oom;

public class UnableCreateThreadDemo {
    public static void main(String[] args) {
        for (int i = 0;  ; i++) {
 // 线程数超出系统限制
            System.out.println(" i = " + i);
            new Thread(()-> {
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
