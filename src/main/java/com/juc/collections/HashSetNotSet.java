package com.juc.collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class HashSetNotSet {
    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();

        /**
         * 1. 使用 Collections 包装
         * 2. 使用 CopyOnWrite
         */
//        Set<String> set = Collections.synchronizedSet(new HashSet<>());
//        final CopyOnWriteArraySet<Object> set = new CopyOnWriteArraySet<>();
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}
