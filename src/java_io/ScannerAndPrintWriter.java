package java_io;

import com.sun.org.apache.xml.internal.serializer.OutputPropertiesFactory;

import java.io.*;
import java.util.Scanner;

public class ScannerAndPrintWriter {
    public static void main(String[] args){
        //
        //test1();

        //
        //test2();

        //
        //test3();

        //
        //test4();

        //
        //test5();

        //
        //test6();

        //
        test7();

        //
    }

    //实例一、从键盘读取
    public static void test1(){
        Scanner sacan = new Scanner(System.in);

        int i = sacan .nextInt();
        System.out.println("你输入的整数为:"+i);
    }

    //实例二、从字符串读取
    public static void test2(){
        Scanner input = new Scanner("hello\r\nworld\r\n");
        while (input.hasNext()){
            String s = input.nextLine();
            System.out.println(s);
        }
    }

    //实例三、从文读取
    public static void test3(){
        String path = "D:"+File.separator+"demo"+File.separator+"text.txt";

        File file = new File(path);
        Scanner input = null;
        try{
            //从文件构造Scanner对象可能触发异常
            input = new Scanner(file);
            while (input.hasNext()){
                String s = input.nextLine();
                System.out.println(s);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            input.close();
        }
    }

    //实例四、向文件写入内容
    public static void test4(){
        String path = "D:"+File.separator+"demo"+File.separator+"text.txt";

        File file = new File(path);
        PrintWriter printWriter = null;
        try{
            //此处构造函数还可以传入其他对象
            printWriter = new PrintWriter(file);

            //向文件中追加
           // printWriter = new PrintWriter(new FileWriter(file,true));

            //向文件写入一行，此外还有print()和printf()方法
            printWriter.println("line1");
            printWriter.println("line2");
            printWriter.println("line3");

            //刷新流
            printWriter.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            printWriter.close();
        }
    }

    //System类中的写入
    public static void test5(){
        //OutputStream是所有字节写入流的父类
        OutputStream outputStream = System.out;
        try{
            //写入数据，只能是数组，所以用getBytes()方法
            outputStream.write("hello world \r\n".getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //System类中的读取
    public static void test6(){
        //InputStream是所有字节输入流的父类
        InputStream inputStream = System.in;
        Util.print("请输入文字：");
        byte[] buf = new byte[1024];
        int len =0;
        try{
            //将输入的数据保存到数组中，len记录输入长度
            // 输入回车截止
            //一旦输入的数据超过1024字节，那麽超出的部分就会被截取掉
            len = inputStream.read(buf);
        }catch (IOException e){
            e.printStackTrace();
        }
        Util.print("你输入的是："+new String(buf,0,len));
    }

    //利用BufferedReader实现对键盘的读取
    public static void test7(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

//        Util.print("请输入文本：");
//        try{
//            String str = bufferedReader.readLine();
//            Util.print("你输入的是："+str);
//        }catch (IOException e){
//            e.printStackTrace();
//        }

        //循环读取方式
        while(true){
            Util.print("请输入文本：");
            String str = null;
            try{
                str = bufferedReader.readLine();
            }catch (IOException e2){
                e2.printStackTrace();
            }
            if("over".equals(str)){
                break;
            }
            Util.print("你输入的是："+str);
        }

        try{
            //关闭流
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
