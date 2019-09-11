package com.xywei.java.nio;

import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * <b>Buffer要点</b>
 * mark: 标记position位置，通过reset()方法得到上一次position位置，类似回滚点。
 * position：数据存放当前位置
 * limit：缓冲区中中可以操作数据的容量，position到limit之间的数据不可读写
 * capacity：缓冲区的最大容量
 * 1，-1<=mark<0<=position<=limit<=capacity
 * 2，基本类型中除了Blooean没有Buffer之外，其他都有。
 * ----
 * 写模式（程序数据写入buffer）：
 * <p>
 * ----
 * 读模式（程序数据从buffer中读取）：
 * ----
 */
public class TestBuffer {

    public static void printOutBuffer(Buffer buffer) {
        System.out.println("position: " + buffer.position());
        System.out.println("limit: " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());
    }

    @Test
    public void testBuffer() {
        //使用非直接内存缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        System.out.println("---初始化buffer---");
        printOutBuffer(byteBuffer);

        System.out.println("--装入数据，put之后---");
        String data="abc我";
        byteBuffer.put(data.getBytes());
        printOutBuffer(byteBuffer);

        System.out.println("---进入flip()模式---");
        byteBuffer.flip();
        printOutBuffer(byteBuffer);

        System.out.println("---进入读取get()模式---");
        byte[] bytes=new byte[byteBuffer.capacity()];
        byteBuffer.get(bytes,0,byteBuffer.limit());
        System.out.println("从buffer中获取的数据是："+new String(bytes));
        printOutBuffer(byteBuffer);
        System.out.println("读取完毕之后数据没有消失，可以通过rewind()重新进去读模式");

        System.out.println("---进入rewind()模式---");
        byteBuffer.rewind();
        printOutBuffer(byteBuffer);

        System.out.println("---清空缓冲区，但是数据依然存在，只是position，limit恢复初始位置---");
        byteBuffer.clear();
        printOutBuffer(byteBuffer);
        System.out.println("---测试clear之后缓冲区数据---");
        byteBuffer.get(bytes);
        System.out.println("clear后缓冲区数据："+new String(bytes));
    }

    @Test
    public void testMark(){
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);

        System.out.println("---初始化---");
        printOutBuffer(byteBuffer);//0,1024,1024

        System.out.println("---put---");
        byteBuffer.put("abc".getBytes());
        printOutBuffer(byteBuffer);//3,1024,1024

        System.out.println("---flip---");
        byteBuffer.flip();
        printOutBuffer(byteBuffer);//0,3,1024

        System.out.println("---get---");
        System.out.println("数据第一个:"+(char)byteBuffer.get());//区分get(0)
        printOutBuffer(byteBuffer);//1,3,1024

        byteBuffer.mark();
        System.out.println("---mark---");
        printOutBuffer(byteBuffer);//1,3,1024

        System.out.println("剩余可操作数据数量："+byteBuffer.remaining());
        byte[] dist = new byte[byteBuffer.capacity()];
        byteBuffer.get(dist,1,2);
        System.out.println("此时全部数据:"+new String(dist));//bc
        System.out.println("---状态---");
        printOutBuffer(byteBuffer);//3,3,1024
        System.out.println("剩余可操作数据数量："+byteBuffer.remaining());

        byteBuffer.reset();
        System.out.println("---reset---");
        printOutBuffer(byteBuffer);//1,3,1024
        System.out.println("剩余可操作数据数量："+byteBuffer.remaining());

    }

}
