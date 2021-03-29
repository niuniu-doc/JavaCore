package com.jvm.oom;

import java.nio.ByteBuffer;

public class DirectBufferMemoryDemo {
    public static void main(String[] args) throws InterruptedException {
        // -Xmx10m -Xms10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
        System.out.println("配置的maxDirectoryMemory：" + sun.misc.VM.maxDirectMemory() / 1024 /1024 + " MB");
        Thread.sleep(300);

        ByteBuffer buffer = ByteBuffer.allocateDirect(6*1024*1024);
    }
}
