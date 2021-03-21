package com.juc.volati;

public class ReSortSeq {
    int a = 0;
    boolean flag = false;
    public void method1() {
        a = 1;
        flag = true;
    }

    public void method2() {
        while (flag) {
            a = a+1;
            if (a != 6) System.out.println("a=" + a);
        }
    }

    public static void main(String[] args) {
        ReSortSeq reSortSeq = new ReSortSeq();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                reSortSeq.method1();
                reSortSeq.method2();
            }).start();
        }
    }
}
