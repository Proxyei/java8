package com.xywei.java.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 1，通道主要分类：
 * 本地IO：FileChannel
 * 网络IO：SocketChannel/ServerSockerChannel/DatagramChannel
 * 2，获取通道：
 * 方法1：
 * 本地IO：
 * 使用FileInputStream/FileOutputStream/RandomAccessFile的getChannel方法
 * 网络IO:
 * Socket/ServerSocket/DatagramSocket的getChannel方法
 * 方法2：
 * JDK1.7之后，NIO.2里面，使用每个通道的open静态方法或者File工具的newByteChannel()
 */
public class TestChannel {

    /**
     * 使用方法1获取通道，非直接缓冲区
     * 功能：实现copy
     */
    @Test
    public void testChannel1() {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        FileChannel fileInputStreamChannel = null;
        FileChannel fileOutputStreamChannel = null;

        try {
            fileInputStream = new FileInputStream("a.jpg");
            fileOutputStream = new FileOutputStream("a1.jpg");
            fileInputStreamChannel = fileInputStream.getChannel();
            fileOutputStreamChannel = fileOutputStream.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            //读入数据到缓冲区，每次写入1024个字节到缓冲区
            while ((fileInputStreamChannel.read(buffer)) != -1) {
                //进入缓冲区的读模式
                buffer.flip();
                //每次从缓冲区读取1024个字节写入a1.jpg
                fileOutputStreamChannel.write(buffer);
                //清空
                buffer.clear();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileInputStreamChannel) {
                    fileInputStreamChannel.close();
                }
                if (null != fileOutputStreamChannel) {
                    fileOutputStreamChannel.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 使用直接缓冲区（映射文件方式）进行复制文件，只有byteBuffer支持mappedByteBuffer
     * 注意：使用的时候耗费的资源较多。
     */
    @Test
    public void testChannel2() throws Exception {

        //打开通道，JDK1.7之后
        FileChannel fileInputChannel = FileChannel.open(Paths.get("a.jpg"), StandardOpenOption.READ);
        FileChannel fileOutputChannel = FileChannel.open(Paths.get("a2.jpg"), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.READ);

        //映射文件
        MappedByteBuffer inputBuffer = fileInputChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileInputChannel.size());
        MappedByteBuffer outputBuffer = fileOutputChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileInputChannel.size());

        //如果文件太小，一次读完
        //读数据
        byte[] dst = new byte[inputBuffer.limit()];
        //如果文件太大，分块读取，不可取，因为文件已经映射为buffer了，也就是数据以及完全写入了buffer中,所以只要一次写入其他文件即可
//        byte[] dst=new byte[512];

        inputBuffer.get(dst);
//        while(inputBuffer.get(dst) !=null){
//            //写数据
        outputBuffer.put(dst);
//
//        }


        fileInputChannel.close();
        fileOutputChannel.close();

    }

    /**
     * 测试直接使用通道的数据传输进行文件copy
     */
    @Test
    public void testChannel3() throws Exception {

        FileChannel inputChannel = FileChannel.open(Paths.get("a.jpg"), StandardOpenOption.READ);
        FileChannel outputChannel = FileChannel.open(Paths.get("a3.jpg"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);

//        inputChannel.transferTo(0, inputChannel.size(), outputChannel);
        outputChannel.transferFrom(inputChannel, 0, inputChannel.size());

        inputChannel.close();
        outputChannel.close();
    }

}
