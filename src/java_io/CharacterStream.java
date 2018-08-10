package java_io;

import java.io.*;


//未考虑到编码方面的问题

public class CharacterStream {
    public static void main(String[] args) {
        String path = "D:"+File.separator+"demo"+File.separator+"text.txt";

        //用来复制写入的文件
        String path1 = "D:"+File.separator+"demo" + File.separator+"copyFile.txt";

        // String path2 = "D:"+File.separator + "information" +File.separator+"Web.config";

        //超过1KB的文件
        // String path2 = "D:"+File.separator + "information" +File.separator+"Web.config";

        //向文件中写入数据
        //CharacterStreamWriter(path);

        //从文本文件中读取数据
        CharacterStreamReadr(path);

        //文本文件的复制
        //CopyFileOfTextFile(path,path1);

        //利用字符流的缓冲区来进行文本文件的复制
       // CopyFileOfTextFileInStreamBuffer(path,path1);

    }

    //向文件中写入数据
    public static void CharacterStreamWriter(String path) {
        //在try语句块的外部定义File Writer的引用
        FileWriter fileWriter = null;
        try {
            //以path为路径创建一个File Writer对象
            //如果以追加的方式写入文件则使用构造函数FileWriter(path,true)
            fileWriter = new FileWriter(path, true);
            //fileWriter = new FileWriter(path);

            //将字符串写入到流中，\r\n表示换行
            //fileWriter.write("以覆盖的形式将字符串写入到文件中\r\n这是下一行\\r\\n表示换行");
            fileWriter.write("\r\n--\r\n以追加的形式将字符串写入到文件中\r\n这是下一行\\r\\n表示换行");


            //flush()函数用于强制刷新缓冲区，例如冲马桶一样，每一次write就是向马桶中放东西，不flush（冲刷）一下不会进入到下水道
            //每一个流都有自己的缓冲区，默认大小是?
            fileWriter.flush();


        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            //如果前面发生了异常不会有对象产生因此需要判断一下，避免空指针异常
            if(fileWriter!=null) {
                //需要再次捕获
                try {
                    //关闭此流，但要先刷新它。在关闭该流之后，再调用 write() 或 flush() 将导致抛出 IOException。关闭以前关闭的流无效。
                    fileWriter.close();
                } catch (IOException e2) {
                    // TODO: handle exception
                    e2.printStackTrace();
                }
            }
        }
    }


    //从文本文件中读取数据
    public static void CharacterStreamReadr(String path) {

        FileReader fileReader = null;
        try{
            fileReader = new FileReader(path);

            //方式一：读取单个字符方法
            //  每读取一次向下移动一个字符单位
//            int temp1 = fileReader.read();
//            System.out.println((char)temp1);
//            int temp2 = fileReader.read();
//            System.out.println((char)temp2);

            //方式二：循环读取
            //read函数读到末尾回返回-1
//            while (true){
//                int temp = fileReader.read();
//                if(temp == -1){
//                    break;
//                }
//                System.out.print((char)temp);
//            }

            //使用这种方法输出字符的时候为什么到了换行的时候前面输出的内容全部都消失了？？？？
            //而使用不带index的重载函数就不会消失，而能够正常显示出所有的字符？？？？

            int temp =0 ;
            while ((temp = fileReader.read())!=-1){
                //Util.print(1,(char)temp);
                Util.print((char)temp);
                // System.out.print((char)temp);
            }
            //方式三：读入到字符数组
//            char[]buf = new char[1024];
//
//            //read():作为整数读取的字符，范围在 0 到 65535 之间 (0x00-0xffff)，如果已到达流的末尾，则返回 -1
//            // read(char[] cbuf,int off,int len):将字符读入数组的某一部分.
//            //cbuf - 目标缓冲区
//            //off - 开始存储字符处的偏移量
//            //len - 要读取的最多字符数
//            //返回：读取的字符数，如果已到达流的末尾，则返回 -1
//            int temp3 = fileReader.read(buf);
//
//            //String的构造函数，将字符数组中的指定部分转化为String
//            System.out.println(new String(buf,0,temp3));
//
            //方式四：读入到字符数组的优化
            //            //由于有时候文件太大，无法确定需要定义的数组大小
            //            //因此一般定义数组长度为1024，采用循环的方式读入

//            char[] buf = new char[1024];
//            int temp4 = 0 ;
//            while ((temp4 = fileReader.read(buf))!= -1){
//                System.out.println(new String(buf,0,temp4));
//            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fileReader != null){
                try{
                    fileReader.close();
                }catch (IOException e2){
                    e2.printStackTrace();
                }
            }
        }
    }


    //文本文件的复制
    public static void CopyFileOfTextFile(String path1,String path2){
        FileWriter fileWriter = null;
        FileReader fileReader = null;
        try{
            fileReader = new FileReader(path1);
            fileWriter = new FileWriter(path2,true);

//            //方式一：单个字符复制
//            int temp = 0;
//            while((temp=fileReader.read())!=-1){
//                fileWriter.write(temp);
//            }

            //方式二：字符数组方式写入
            char[] buf = new char[1024];
            int tem = 0;
            while ((tem = fileReader.read(buf))!=-1){
                fileWriter.write(new String(buf,0,tem));
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fileReader !=null){
                try{
                    fileReader.close();
                }catch (IOException e2){
                    e2.printStackTrace();
                }
            }
            if(fileWriter != null){
                try{
                    fileWriter.close();
                }catch (IOException e3){
                    e3.printStackTrace();
                }
            }
        }
    }

    //利用字符流的缓冲区来进行文本文件的复制
    public static void CopyFileOfTextFileInStreamBuffer(String path,String path1){
        FileReader fileReader= null;
        FileWriter fileWriter =null;

        //创建缓冲区的引用
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter =null;

        try{
            fileReader = new FileReader(path);
            fileWriter = new FileWriter(path1,true);
            //创建缓冲区对象
            //将需要提高效率的两个流对象分别放入他们的构造函数中
            //当然也可以只用匿名对象方式：br = new BufferedReader(new FileReader(doc));
            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);

            String line = null;
            //读取行，直到返回null
            //readLine方法只返回换行符之间的数据
            while((line = bufferedReader.readLine())!=null){
                //使用bufferedWriter对象的方法写入
                bufferedWriter.write(line);
                //写完文件内容之后换行
                //newLine()方法依据平台而定
                //windows下的换行是\r\n
                //Linux下则是\n
                bufferedWriter.newLine();
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //此处不再需要捕获FileWriter和FileReader对象的异常了，关闭缓冲区就是关闭缓冲区中的流对象
            if(bufferedReader!=null){
                try{
                    bufferedReader.close();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
            }
            if(bufferedWriter !=null){
                try{
                    bufferedWriter.close();
                }catch (IOException e2){
                    e2.printStackTrace();
                }
            }
        }

    }

}
