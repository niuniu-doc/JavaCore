package com.multiThread.old;

public class Test9 {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        // Thread.interrupted 判断当前线程是否停止的状态，并清除中断状态
        System.out.println("stop " + Thread.interrupted());
        System.out.println("stop " + Thread.interrupted());

    }
}
