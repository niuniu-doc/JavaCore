package com.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;

/**
 * @author nj
 * @date 2022/1/20 10:41 AM
 * 从网络中读取数据
 **/
public class SocketChannel {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            InetSocketAddress address = new InetSocketAddress("127.0.0.1", 6780);
            serverSocketChannel.bind(address); // 绑定地址、端口号
            ByteBuffer buffer = ByteBuffer.allocate(1024); // 创建缓冲区
            while (true) {
                // 获取channel
                java.nio.channels.SocketChannel channel = serverSocketChannel.accept(); // 监听端口变动
                while (channel.read(buffer) !=  -1) {
                    // socket 中还有数据
                    System.out.println(new String(buffer.array()));
                    // 清空缓冲区
                    buffer.clear();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
