package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author nj
 * @date 2022/1/20 11:31 AM
 * transferFrom 文件内容从指定文件中读取
 * transferTo 将内容输出到指定文件
 **/
public class Channel2Channel {
    public static void main(String[] args) {
        try {
            File file = new File("a.txt");
            FileInputStream inStream = new FileInputStream(file);
            FileChannel inChannel = inStream.getChannel();

            // 创建输出流
            FileOutputStream outStream = new FileOutputStream("b.txt");
            FileChannel outChannel = outStream.getChannel();

            // 创建buffer
            ByteBuffer buffer = ByteBuffer.allocate((int) file.length());
            //inChannel.transferTo(0, buffer.limit(), outChannel);
            outChannel.transferFrom(inChannel, 0, buffer.limit());

            // 关闭通道，关闭输入输出流
            outStream.close();
            inStream.close();
            outChannel.close();
            inChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
