package com.jvm;

import java.lang.ref.SoftReference;

public class SoftReferenceDemo {
    public static void softRef_Memory_Enough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();

        System.out.println(o1); // 被手动置空
        System.out.println(softReference.get()); // 内存足够时不会被回收
    }

    public static void softRef_Memory_NotEnough(){
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        try {
            byte[] bytes = new byte[30*1024*1024]; // 超出heap大小，触发gc
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(o1); // 被手动置空
            System.out.println(softReference.get()); // 内存不足够时会被回收
        }


    }

    public static void main(String[] args) {
//        softRef_Memory_Enough();
        softRef_Memory_NotEnough();
    }
}
