package com.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author nj
 * @date 2022/1/20 3:39 PM
 * 服务端监听代码
 **/
public class NIOServer {
    public static void main(String[] args) {
        try {
            // 打开一个serverSocketChannel并绑定地址
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            InetSocketAddress address = new InetSocketAddress("127.0.0.1", 7890);
            serverSocketChannel.bind(address);
            System.out.println(serverSocketChannel.isBlocking());
            serverSocketChannel.configureBlocking(false); // 设为非阻塞
            System.out.println(serverSocketChannel.isBlocking());

            // 打开一个选择器, 并将serverSocketChannel注册进去,同时监听连接事件
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            // 等待客户端连接
            while (true) {
                // 等待3s，若返回0,相当于没有事件, 继续
                if (selector.select(3000) == 0) {
                    System.out.println("server has no connect, continue.");
                    continue;
                }
                // 获取事件
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                while (it.hasNext()) {
                    SelectionKey selectionKey = it.next();
                    if (selectionKey.isAcceptable()) {
                        // 连接事件，建立连接, 获取socketChannel, 并绑定缓冲区
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    }
                    if (selectionKey.isReadable()) {
                        // 读事件，获取通道及关联的buffer
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
                        socketChannel.read(buffer);
                        System.out.println("read from client: " + new String(buffer.array()));
                    }
                    it.remove(); // 从事件集合中移除已处理事件, 防止重复处理
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
