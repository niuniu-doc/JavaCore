package com.io;

import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.charset.StandardCharsets;

/**
 * @author nj
 * @date 2022/1/24 2:08 PM
 * 通过sink通道向管道写数据, source通道，从管道读取数据
 **/
public class PipeChannel {
    public static void main(String[] args) {
        try {
            Pipe pipe = Pipe.open();
            Pipe.SinkChannel sinkChannel = pipe.sink();
            // 向sinkChannel中写入数据
            String data = "test" + System.currentTimeMillis();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.clear();
            buffer.put(data.getBytes(StandardCharsets.UTF_8));
            buffer.flip();
            while (buffer.hasRemaining()) {
                sinkChannel.write(buffer);
            }
        } catch (Exception e) {
            // ignore.
        }

    }
}
