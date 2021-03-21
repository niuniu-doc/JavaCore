package com.juc.volati;

public class SeeOK {
    static class MyData {
        private volatile int number = 0;  // 将变量添加volatile修饰，修改对其它线程可见
        public void addTo60() {
            this.number = 60; // 调用方法，将值加到60
        }
    }

    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(() -> { // 线程1修改变量值
            System.out.println(Thread.currentThread().getName() + " come in");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + " reset done.");
        }, "aaa").start();

        while (myData.number == 0) {
            // 若线程 aaa 的修改可以被其它线程读到，
            // 则main线程会跳出循环，打印下边的语句，否则，会一直在这里循环
        }

        System.out.println("main, over");
    }
}
