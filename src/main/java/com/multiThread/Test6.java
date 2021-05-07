package com.multiThread;

public class Test6 {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        /**
         * Thread.getId 获取线程编号
         * Thread.getName 获取线程名称
         * Thread.getPriority 获取线程优先级
         */
        System.out.println("thread.Name: " + thread.getName() +
                " thread.id: " + thread.getId() +
                " thread.priority: " + thread.getPriority());

    }
}
