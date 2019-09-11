package com.xywei.java.nio.network;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;

/**
 * 阻塞/非阻塞是针对网络而言
 */
public class TestBlockIO {

    /**
     * 功能：客户端传输图片，获取服务端反馈。
     */
    @Test
    public void testBlockIOClient() throws Exception {

        //打开网络IO通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 10086));

        //打开本地IO通道
        FileChannel fileChannel = FileChannel.open(Paths.get("a.jpg"), StandardOpenOption.READ);

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        //把本地的IO输入写入网络IO通道
        while (fileChannel.read(byteBuffer) != -1) {
            //进入读模式
            byteBuffer.flip();
            //写入网络IO
            //卡住在这里，如何写？
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        //TODO 阻塞IO、非阻塞IO区别就是在这里，服务端无法知道客户端是否发送完毕数据。因为在这里自己也卡了很久，没收到消息。
        socketChannel.shutdownOutput();

        //监听网络IO的反馈
        int len = 0;

        //从网络中每次读入1024个字节到buffer中。
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println("--client--1");
        while ((len = socketChannel.read(buffer)) != -1) {
            System.out.println("--client--2");
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, len));
            buffer.clear();
        }


        fileChannel.close();
        socketChannel.close();

    }

    /**
     * 服务端
     */
    @Test
    public void testBlockIOServer() throws Exception {

        //打开本地、网络通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        FileChannel fileChannel = FileChannel.open(Paths.get(Calendar.getInstance().getTimeInMillis() + "bio.jpg"),
                StandardOpenOption.CREATE, StandardOpenOption.READ, StandardOpenOption.WRITE);

        //监听网络端口
        serverSocketChannel.bind(new InetSocketAddress(10086));
        //进入监听状态
        SocketChannel socketChannel = serverSocketChannel.accept();

        ByteBuffer dst = ByteBuffer.allocate(1024);
        while (socketChannel.read(dst) != -1) {
            dst.flip();
            //写到本地
            fileChannel.write(dst);
            dst.clear();
        }

        //回复消息给客户端
        String message = "你好，已经收到了！";
//        fileChannel.read(dst.put(message.getBytes()));
        dst.put(message.getBytes());
        dst.flip();
        System.out.println("---server---");
        socketChannel.write(dst);

        socketChannel.close();
        fileChannel.close();
        serverSocketChannel.close();

    }

}
