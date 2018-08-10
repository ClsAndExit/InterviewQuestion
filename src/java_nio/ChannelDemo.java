package java_nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelDemo {
    public static void main(String[]args) throws IOException{
        //当前程序所在目录
        //String relativelyPath = System.getProperty("user.dir");
        String path = "D:"+File.separator+"demo"+File.separator+"text.txt";
        String path2 = "D:"+File.separator+"demo"+File.separator+"text2.txt";

        FileInputStream input = new FileInputStream(path);
        //文件通道用于从文件读取数据。它只能通过调用getChannel()方法来创建对象。不能直接创建FileChannel对象。
        ReadableByteChannel source = input.getChannel();
        FileOutputStream output = new FileOutputStream(path2);
        WritableByteChannel destination = output.getChannel();
        copyData(source,destination);
        source.close();
        destination.close();
        System.out.println("Copy data Finished");
    }

    public static void copyData(ReadableByteChannel src, WritableByteChannel dest)throws IOException{
        //ByteBuffer.allocate(capacity)与ByteBuffer.allocateDirect(capacity)的区别
        /**
         * ByteBuffer.allocate(capacity)分配一个新的字节缓冲区。
         * 新缓冲区的位置将为零，其界限将为其容量，其标记是不确定的。它将具有一个底层实现数组，且其 数组偏移量将为零
         *
         * ByteBuffer.allocateDirect(capacity)分配新的直接字节缓冲区。
         * 新缓冲区的位置将为零，其界限将为其容量，其标记是不确定的。无论它是否具有底层实现数组，其标记都是不确定的。
         * 该方法直接使用操作系统分配buffer
         *
         * 当数据量10240000以下时，两种方法耗时相当，当buffer容量变得很大时第二种分配方式更加节省时间
         */
        ByteBuffer buffer = ByteBuffer.allocateDirect(20*1024);
        while (src.read(buffer)!=-1){
            /**
             * 反转此缓冲区。首先将限制设置为当前位置，然后将位置设置为 0。如果已定义了标记，则丢弃该标记。
             * 在一系列通道读取或放置 操作之后，调用此方法为一系列通道写入或相对获取 操作做好准备。
             */
            buffer.flip();
            //确保缓冲区已完全耗尽
            while (buffer.hasRemaining()){
                dest.write(buffer);
            }
            //现在缓冲区为空，准备填充
            //此方法不能实际清除缓冲区中的数据，但从名称来看它似乎能够这样做，这样命名是因为它多数情况下确实是在清除数据时使用。
            buffer.clear();
        }
    }
}
