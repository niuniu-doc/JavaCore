//package com.io;
//
//import java.net.InetSocketAddress;
//import java.nio.ByteBuffer;
//import java.nio.channels.*;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
///**
// * @author nj
// * @date 2022/1/24 4:24 PM
// **/
//public class NIO2Server {
//    public void listen() {
//        try {
//            // 创建一个线程池
//            ExecutorService es = Executors.newCachedThreadPool();
//            // 创建异步通道群组
//            AsynchronousChannelGroup cg = AsynchronousChannelGroup.withCachedThreadPool(es, 10);
//            // 创建异步通道并绑定群组
//            AsynchronousServerSocketChannel ac = AsynchronousServerSocketChannel.open(cg);
//            // 绑定端口
//            ac.bind(new InetSocketAddress(8090));
//            // 监听连接, 传入回调类处理请求
//            ac.accept(this, new AcceptHandler());
//        } catch (Exception e) {
//            // ignore
//        }
//}
//
//class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, NIO2Server> {
//
//    @Override
//    public void completed(AsynchronousSocketChannel asc, NIO2Server attachment) {
//        attachment.assc.accept(attachment, this);
//
//        //1. 先分配好 Buffer，告诉内核，数据拷贝到哪里去
//        ByteBuffer buf = ByteBuffer.allocate(1024);
//
//        //2. 调用 read 函数读取数据，除了把 buf 作为参数传入，还传入读回调类
//        channel.read(buf, buf, new ReadHandler(asc));
//    }
//
//    @Override
//    public void failed(Throwable exc, NIO2Server attachment) {
//
//    }
//}
