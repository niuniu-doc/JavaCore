package com.io;


import sun.nio.ch.DirectBuffer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author nj
 * @date 2022/1/19 9:23 AM
 * read from file
 **/
public class FileChannel {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("/Users/nj/www/Java/JavaCore/src/main/java/com/io/a.txt", "rw");
        java.nio.channels.FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(15);

        // ByteBuffer.wrap 将字节数组读入buffer
//        ByteBuffer buffer1 = ByteBuffer.wrap("test".getBytes(StandardCharsets.UTF_8));
//        int bytesRead = channel.read(buffer1);
        int bytesRead = channel.read(buffer);
        while (bytesRead != -1) {
            System.out.println("Read: " + bytesRead);
            buffer.flip();
            while (buffer.hasRemaining()) {
                // 若buffer中还有数据
                System.out.println((char) buffer.get()); // 将其转换为char类型输出
            }
            buffer.clear();
            bytesRead = channel.read(buffer);
        }
        file.close();
    }
}
