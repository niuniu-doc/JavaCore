package com.yun;

import java.lang.ref.SoftReference;

public class GcTest {
    public static void gc1() {
        byte[] a = new byte[1024*1024*6];
        System.gc();
    }

    public static void alloc() {
        Student student = new Student(1,"yunyun");
    }

    public static void test() {
        long b = System.currentTimeMillis();
        for(int i=0;i<100000000;i++) {
            alloc();
        }
        System.out.println(System.currentTimeMillis()-b);
    }
    public static void main(String[] args) {
        byte[] c = new byte[1024*20];
        //byte[] a = new byte[1024*1024*6];
        //a = null;
        //byte[] b = new byte[1024*1024*6];

    }
}
