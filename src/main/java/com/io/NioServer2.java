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
 * @date 2022/1/20 4:14 PM
 **/
public class NioServer2 {
    public static void main(String[] args) {
        try {
            // 打开serverSocketChannel, 并绑定监听端口
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            InetSocketAddress address = new InetSocketAddress("127.0.0.1", 7890);
            serverSocketChannel.bind(address);

            // 创建一个selector
            Selector selector = Selector.open();
            serverSocketChannel.configureBlocking(false); // 设置为非阻塞
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT); // 监听连接事件

            while (true) {
                // 等待3s, 若无事件到达，继续
                if (selector.select(3000) > 0) {
                    System.out.println("no event.");
                    continue;
                }
                //获取迭代器遍历
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                while (it.hasNext()) {
                    SelectionKey selectionKey = it.next();
                    if (selectionKey.isAcceptable()) {
                        // 连接事件, 建立连接, 并绑定输入缓冲区
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ, new ByteBuffer[1024]);
                    }
                    if (selectionKey.isReadable()) {
                        // 读事件, 建立通道, 并读取数据
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
                        channel.read(byteBuffer);
                        System.out.println(new String(byteBuffer.array()));
                    }
                    it.remove(); // 移除已处理的事件
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
