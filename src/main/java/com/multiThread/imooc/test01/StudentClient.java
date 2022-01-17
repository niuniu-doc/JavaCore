package com.multiThread.imooc.test01;

public class StudentClient {
    public static void main(String[] args) {
        Punishment punishment = new Punishment(100,"internationalization");
////        Student student = new Student("xiaoming", punishment);
////        student.copyWord();
//        StudentMulti student = new StudentMulti("xiaoming", punishment);
//        student.start(); // 启动线程，此时调用copyWord的是 thread 线程，不再是main线程

        /**
         * 使用Runnable方式与Thread方式的本质是一样的，只是 Runnable 是接口，而Thread是类
         * 启动时、实现一个thread将接口的对象通过构造函数传进去
         */
        Thread xiaoming = new Thread(new StudentRunnable("xiaoming", punishment), "xiaoming");
        xiaoming.start();

        Thread xiaoxue = new Thread(new StudentRunnable("xiaoxue", punishment), "xiaoxue");
        xiaoxue.start();
    }
}
