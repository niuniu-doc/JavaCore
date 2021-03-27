package com.juc.collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListNotSafe {
    public static void main(String[] args) {
        /**
         * Q: java.util.ConcurrentModificationException
         *
         */
//       List<String> list = new ArrayList<>();
        // 用collections类解决
//       List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
