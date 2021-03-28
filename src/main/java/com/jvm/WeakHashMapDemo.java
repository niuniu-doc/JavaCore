package com.jvm;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        MyHashMap();
        System.out.println("=================");
        MyWeakHashMap();
    }

    public static void MyHashMap() {
        HashMap<Integer, String> map = new HashMap<>();
        Integer key = new Integer("1");
        String value = "hashMap2";
        map.put(key, value);

        System.out.println(map);
        key = null;
        System.out.println(map); // node 节点不会发生变化

        System.gc();
        System.out.println(map.size());
    }

    public static void MyWeakHashMap() {
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer key = new Integer("2");
        String value = "WeakHashMap";
        map.put(key, value);

        System.out.println(map);
        key = null;
        System.out.println(map); // node 节点不会发生变化

        System.gc();
        System.out.println(map.size());
    }
}
