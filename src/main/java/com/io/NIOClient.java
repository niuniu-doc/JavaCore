package com.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author nj
 * @date 2022/1/20 4:33 PM
 **/
public class NIOClient {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            InetSocketAddress address = new InetSocketAddress("127.0.0.1", 7890);
            socketChannel.configureBlocking(false);
            boolean connect = socketChannel.connect(address); // 建立指定socket的连接
            if (!connect) {
                while (!socketChannel.finishConnect()) {
                    System.out.println("connect needs time, do something else.");
                }
            }
            String msg = "test for socketChannel";
            ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8));
            socketChannel.write(byteBuffer);
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
