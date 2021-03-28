package com.jvm;

public class HelloGC {
    public static void main(String[] args) throws Exception{
        byte[] bytes = new byte[1024*1024*1024];
        System.out.println("Hello GC.");
        Thread.sleep(Integer.MAX_VALUE);

        long total = Runtime.getRuntime().totalMemory();
        long max = Runtime.getRuntime().maxMemory();

        System.out.println("total : " + total / 1024 / 1024 + "MB");
        System.out.println("max : " + max / 1024 / 1024 + "MB");
    }
}
