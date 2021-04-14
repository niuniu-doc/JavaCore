package com.jvm;

/**
 * -XX:NewSize=10485760 -XX:MaxNewSize=10485760
 * -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520
 * -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
 * -XX:PretenureSizeThreshold=3145728 设置直接进入老年代的大对象大小3m
 * -XX:+UseParNewGC - XX:+UseConcMarkSweepGC
 * -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
 * -Xloggc:gc.log
 */
public class TestFullGc {
    public static void main(String[] args) {
        byte[] array1 = new byte[4*1024*1024];
        array1 = null; // 大对象的大小阈值时3M，array1的大小是4M，所以会直接放入老年代

        byte[] array2 = new byte[2*1024*1024]; // 分配2m的对象在新生代 eden区
        byte[] array3 = new byte[2*1024*1024]; // 继续分配2m
        byte[] array4 = new byte[2*1024*1024]; // 分配2m
        byte[] array5 = new byte[128*1024]; // 分配128k

        /**
         * 此时新生代空间不足，会触发gc，老年代总大小是10，此时已占用4m(array1),
         * 不足以放下新生代的全部对象 6m+128k
         */
        byte[] array6 = new byte[2*1024];
    }
}
