package com.jvm.oom;

import java.util.ArrayList;
import java.util.List;

public class GcOverheadDemo {
    // -Xmx10m -Xms10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();

        try {
            while (true) {
               list.add(String.valueOf(i++).intern()); // 连续GC回收导致大量cpu占用、回收效果却很差
            }
        } catch (Exception e) {
            System.out.println("i = " + i);
            e.printStackTrace();
            throw e;
        }
    }
}
