package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/**
 * @author nj
 * @date 2022/1/20 2:23 PM
 * 分散读取,聚合输出,分配一个缓冲区数组, 根据需要自动分配缓冲区大小,
 * 可以减少内存消耗
 **/
public class GatheringChannel {
    public static void main(String[] args) {
        try {
            File file = new File("a.txt");
            FileInputStream inStream = new FileInputStream(file);
            FileChannel inChannel = inStream.getChannel();

            FileOutputStream outSteam = new FileOutputStream("b.txt");
            FileChannel outChannel = outSteam.getChannel();

            // 创建一组buffer, 作为数据缓冲区
            ByteBuffer buffer1 = ByteBuffer.allocate(5);
            ByteBuffer buffer2 = ByteBuffer.allocate(5);
            ByteBuffer buffer3 = ByteBuffer.allocate(5);

            ByteBuffer[] buffers = new ByteBuffer[] {buffer1, buffer2, buffer3};
            int sumLen = 0, read = 0;
            while ((read = (int) inChannel.read(buffers)) != -1) {
                sumLen += read;
                Arrays.stream(buffers)
                        .map(buffer -> "positon: " + buffer.position() + ", limit: " + buffer.limit())
                        .forEach(System.out::println);
                Arrays.stream(buffers).forEach(Buffer::flip);
                outChannel.write(buffers);
                Arrays.stream(buffers).forEach(Buffer::clear);
            }
            // 关闭
            outSteam.close();
            inStream.close();
            outChannel.close();
            inChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
