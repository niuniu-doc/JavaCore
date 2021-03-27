package com.juc.lock;

import java.util.HashMap;
import java.util.Map;

class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    public void put(String key, Object val) {

    }
}
public class ReadWriteLock {
}
