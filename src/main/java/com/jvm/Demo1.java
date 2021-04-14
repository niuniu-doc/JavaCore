package com.jvm;

import java.util.concurrent.TimeUnit;

public class Demo1 {
    public static void main(String[] args) throws Exception{
        TimeUnit.SECONDS.sleep(5);
        while (true) {
            loadData();
        }
    }

    public static void loadData() throws Exception{
        byte[] data = null;
        for (int i = 0; i < 50; i++) {
            data = new byte[100*1024];
        }
        data = null;
        Thread.sleep(1000);
    }
}
