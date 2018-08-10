package java_io;

import java.io.File;
import java.io.IOException;

public class FileOperation {
    public static void main(String[] args){

        //创建要操作的文件路径和名称
//        createFileObject();
        //创建和删除文件
        //createOrDeleteFile();

        //文件的测试和判断
        //documentTestingANdJudgement();

        //创建目录
        //credateDitionary();

        //获取文件信息
        //getMessageOfFile();

        //列出目录下的所有文件
        //printFileIntheDictionary();

        //递归列出目录下的所有文件\
        printFileIntheDictionaryByRecursive();
    }

    //创建要操作的文件路径和名称
    public static void createFileObject(){
        //创建要操作的文件路径和名称
        //path在此程序里面代表父目录，不包含子文件
        String path = "D:"+File.separator+"demo"+File.separator;

        //childPath在此程序中代表子目录，包含子文件
        String childPath = "D:"+File.separator+"demo"+File.separator+"text.txt";

        //方式一：用父目录和子文件分割的方式构造File对象
        File f1 = new File(path,"text.txt");

        //方式二：使用绝对路径构造File对象

        File f2 = new File(childPath);

        //方式三：分级构造
        //创建父目录的文件对象
        File d = new File(path);
        //使用已有父目录对象和子文件构建新的FIle对象
        File f3 = new File(d,"text.txt");

        Util.print(1,f1);
        Util.print(2,f2);
        Util.print(3,f3);

    }

    //创建和删除文件
    public static void createOrDeleteFile(){
        String path = "D:"+File.separator+"demo"+File.separator+"text.txt";
        File file = new File(path);
        try{
            //因为创建和删除文件涉及到底层操作，可能会发生异常

            //如果创建成功则会返回true；如果文件已经存在，则创建不成功，返回false，别以为会覆盖
            Util.print(1, String.format("创建文件" + file.createNewFile()));
            //删除文件
            Util.print(2,"删除文件"+ file.delete());

            //此方法表示在虚拟机退出时删除文件
            //原因在于：程序运行时有可能发生异常造成直接退出，清理残余很有必要
            file.deleteOnExit();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //文件的测试和判断
    public static void documentTestingANdJudgement(){
        String path = "D:"+File.separator+"demo"+File.separator+"text.txt";

        File f = new File(path);

        //判断文件是否可执行
        System.out.println("f是否可执行:" + f.canExecute());

        //判断文件是否存在
        System.out.println("f是否存在:" + f.exists());

        //判断文件是否可读
        System.out.println("f是否可读：" + f.canRead());

        //判断文件是否可写
        System.out.println("f是否可写：" + f.canWrite());

        //判断文件是否为绝对路径名
        System.out.println("f是否绝对路径：" + f.isAbsolute());

        /////需要注意的是，如果使用isFlie()和isDirectory()进行测试，
        // 则先要确定文件对象是否已经创建
        //判断文件是否为一个标准文件
        System.out.println("f是否为标准文件：" + f.isFile());

        //判断文件是否为一个目录
        System.out.println("f是否为目录：" + f.isDirectory());

        //判断文件是否隐藏
        System.out.println("f是否隐藏：" + f.isHidden());
    }

    //创建目录
    public static void credateDitionary(){
        String path = "D:"+File.separator+"demo"+File.separator;

        //path在此处作为父目录存在
        File file1 = new File(path,"/abc");
        File file2 = new File(path,"/d/e/f/g");

        //创建一个目录
        System.out.println(file1.mkdir());

        //递归创建目录
        System.out.println(file2.mkdirs());

    }

    //获取文件信息
    public static void getMessageOfFile(){
        String childPath = "D:"+File.separator+"demo"+File.separator+"text.txt";
        File f = new File(childPath);

        //返回文件的绝对路径
        //此处返回值为String
        System.out.println("f的绝对路径名：" + f.getAbsolutePath());

        //返回文件的绝对路径
        //此处返回值为File
        System.out.println("f的绝对路径对象：" + f.getAbsoluteFile());

        //返回文件或目录的名称
        System.out.println("f的名称：" + f.getName());

        //返回文件的相对路径
        //构造函数中封装的是什么路径，就返回什么路径
        System.out.println("f的路径：" + f.getPath());

        //返回父目录的路径
        //如果在构造函数中的路径不是绝对路径，那么此处返回null
        System.out.println("f的父目录：" + f.getParent());

        //listRoots()是一个静态方法，返回文件数组
        File []files = File.listRoots();

        //循环打印出File对象，在Linux系统中根目录只有一个/，在Windows下列出所有的盘符
        for (File x: files
             ) {
            System.out.println(x);
        }
    }

    //列出目录下的所有文件
    public static void printFileIntheDictionary(){

        String path = "D:"+File.separator+"demo"+File.separator;
        File file = new File(path);
        //方式一：list()
        //返回一个包含指定目录下所有文件的字符串数组
        //如果不是一个目录则返回null
        String [] files = file.list();
        for (String x:files
             ) {
            System.out.println(x);
        }

        //方式二：listFiles()
        //返回file数组
        File[] files1 = file.listFiles();
        for (File x:files1
             ) {
            System.out.println(x.getName());
        }
    }


    //以递归方式打印出目录下的所有文件
    public static void printFileIntheDictionaryByRecursive(){
        String path = "D:"+File.separator+"demo"+File.separator;
        File file = new File(path);
        print(file);
    }
    //用递归的方式打印目录列表
    public static void print(File file){
        if(file.isDirectory()){
            File [] files = file.listFiles();
            if(files != null){
                for (File x:files
                        ) {
                    print(x);
                }
            }
        }else {
            System.out.println(file);
        }
    }
}
