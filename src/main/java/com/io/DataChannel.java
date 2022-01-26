package com.io;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @author nj
 * @date 2022/1/21 3:58 PM
 **/
public class DataChannel {
    public static void main(String[] args) {
        try {
            DatagramChannel channel = DatagramChannel.open();
            channel.bind(new InetSocketAddress("127.0.0.1", 7890));
            ByteBuffer buffer = ByteBuffer.allocate(10);
            buffer.clear();
            channel.receive(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
