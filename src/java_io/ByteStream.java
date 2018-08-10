package java_io;

import java.io.*;

/**
 * 总结：字符流：用于操作类似文本文件或者带有字符文件的场合比较多
 * 而字节流则是操作那些无法直接获取文本信息的二进制文件，如图片，音频等
 * 其实文件在硬盘上都是以字节存储的，之不过字符流在操作文本上面更加方便一些
 *
 * 解释一下为什么要使用缓冲区：
 * 试想一下，如果一有数据，不论大小就开始读写，势必会给硬盘造成很大负担，它会感觉很不爽
 * 人不也一样，一顿饭不让你一次吃完，每分钟喂一勺，你怎么想？
 * 使用缓冲区能够在读写大文件的时候有效提高效率
 */
public class ByteStream {
    public static void main(String[] args){
        String path = "D:"+File.separator+"demo"+File.separator+"test.png";

        String copyPath = "D:"+File.separator+"demo"+File.separator+"test2.jpg";
        //字节流的插入
//        ByteStreamWriter(path);

        //字节流的读取
        //ByteStreamReader(path);

        //二进制文件的复制
        //ByteFileCopy(path,copyPath);

        //利用字节流的缓冲区进行二进制文件的复制
        ByteFileCopyInBuffer(path,copyPath);
    }

    //字节流的插入
    public static void ByteStreamWriter(String path){
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(path);
            String str = "向文本文件中插入文本\r\n" +
                    "abcdefg\r\n";
            byte[] buf = str.getBytes();
            //也可以直接使用o.write("String".getBytes());
            //因为字符串就是对象，能直接调用方法
            fileOutputStream.write(buf);

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fileOutputStream!=null){
                try{
                    fileOutputStream.close();
                }catch (IOException e2){
                    e2.printStackTrace();
                }
            }
        }
    }

    //字节流的读取
    public static void ByteStreamReader(String path){
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream(path);
            //方式一：单个字符读取
            //可能应该是使用ASCII码来转化的，中文乱码
//            int ch = 0;
//            while((ch = fileInputStream.read())!=-1){
//                System.out.print((char)ch);
//            }

            //方式二：数组循环读取
//            //采用此方法可以打印出汉字
//            byte[] buf = new byte[1024];
//            int len =0;
//            while ((len = fileInputStream.read(buf))!=-1){
//                System.out.println(new String(buf,0,len));
//            }

            //方式三：定一个一个刚好大小的数组
            //available()方法返回文件的字节数
            //但是，如果文件过大，内存溢出，那就悲剧了
            byte[] bufer = new byte[fileInputStream.available()];
            fileInputStream.read(bufer);
            //因为数组大小刚好，所以转换为字符串时无需在构造函数中设置起始点
            System.out.println(new String(bufer));

        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //二进制文件的复制
    public static void ByteFileCopy(String path1,String path2){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try{
            fileInputStream = new FileInputStream(path1);
            fileOutputStream = new FileOutputStream(path2);

            byte[] buf = new byte[1024];
            int temp = 0;
            while ((temp = fileInputStream.read(buf))!=-1) {
                fileOutputStream.write(buf,0,temp);
            }
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 利用字节流的缓冲区进行二进制文件的复制
    public static void ByteFileCopyInBuffer(String path1,String path2){
        FileInputStream i = null;
        FileOutputStream o = null;
        BufferedInputStream bi = null;
        BufferedOutputStream bo = null;

        try {
            i = new FileInputStream(path1);
            o = new FileOutputStream(path2);
            bi = new BufferedInputStream(i);
            bo = new BufferedOutputStream(o);

            byte[] buf = new byte[1024];
            int temp = 0;
            while((temp = bi.read(buf)) != -1) {
                bo.write(buf,0,temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bi != null) {
                try {
                    i.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bo != null) {
                try {
                    o.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
