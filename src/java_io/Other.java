package java_io;

import java.io.*;

//@SuppressWarnings("serial")
//一个类想要实现序列化则必须实现serializable接口
class Persion implements Serializable{
    private String name;
    private int age;
    public Persion(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return "Name:"+this.name+",Age:"+this.age;
    }
}
//实现Runnable接口，实现一个读的线程
class Read implements Runnable{
    private PipedInputStream in;

    //将需要读的管道流传入到构造函数
    public Read(PipedInputStream in){
        this.in = in;
    }

    //实现读这一线程
    @Override
    public void run() {
        try{
            byte[] buf = new byte[1024];
            int tem = 0;
            /**
             * 循环读取
             * read是一个阻塞方法，需要抛异常
             * 此处把打印流的代码也加入进来，
             * 因为如果没有读取到数据，那么打印代码无效
             */
            while((tem = in.read(buf))!=-1){
                String str = new String(buf,0,tem);
                Util.print(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                in.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

//实现一个写的线程
class Write implements Runnable{
    private PipedOutputStream out;
    //将管道输入流传递进来
    public Write(PipedOutputStream out){
        this.out =out;
    }

    @Override
    public void run() {
        try{
            out.write("管道输出：".getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Other{
    public static void main(String[] args){
        //对象的序列化
        //test1();

        //实例二、对象的反序列化
        //test2();

        //实例三、线程的通信
        //test3();

        //实例四、基本数据类型的写入
        //test4();

        //实例五、基本数据类型的读取
        test5();
    }

    /**
     * 所谓对象序列化就是把一个对象进行持久化存储，方便保留其属性
     * 通俗点说，等于把一个对象从堆内存里边揪出来放到硬盘上
     */
    //实例一、对象的序列化
    public static void test1(){
        String path = "D:"+File.separator+"demo"+File.separator+"text.txt";

        Persion p1 = new Persion("Tom",22);
        Persion p2 = new Persion("Jery",22);

        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream(path);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(p1);
            objectOutputStream.writeObject(p2);

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                objectOutputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    //实例二、对象的反序列化
    public static  void  test2(){
        String path = "D:"+File.separator+"demo"+File.separator+"text.txt";
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try{
            fileInputStream = new FileInputStream(path);
            objectInputStream  = new ObjectInputStream(fileInputStream);

            Persion persion = (Persion)objectInputStream.readObject();
            Persion persion1 = (Persion)objectInputStream.readObject();
            Util.print(persion1.toString());

        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e2){
            e2.printStackTrace();
        }finally {
            try{
                objectInputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    //实例三、线程的通信
    public static void test3(){
        PipedInputStream in = new PipedInputStream();
        PipedOutputStream out = new PipedOutputStream();
        try {
            //连接管道
            in.connect(out);

            //创建对象，开启线程
            //此处同样放进try...catch里面
            //因为如果没有链接管道，下面操作无意义
            Read r = new Read(in);
            Write w = new Write(out);
            //把已经实现好run方法的对象放入线程中执行
            new Thread(r).start();
            new Thread(w).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //实例四、基本数据类型写入
    public static void test4(){
        String path = "D:"+File.separator+"demo"+File.separator+"text.txt";
        DataOutputStream d =null;
        try {
            //此处要传入一个Output Stream类的对象
            d = new DataOutputStream(new FileOutputStream(path));

            //开始写入基本数据类型
            /**
             * 此处我们并不能直观看懂内容，因为它采用字节流的方式操作，而不是字符流
             * 我们只需要知道，此程序已经将基本数据类型写入到硬盘即可
             */
            d.writeInt(12);
            d.writeBoolean(true);
            d.writeDouble(12.2223);
            d.writeChar(97);
            //刷新流
            d.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                d.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //实例五、基本数据类型的读取
    public static void test5(){
        String path = "D:"+File.separator+"demo"+File.separator+"text.txt";
        DataInputStream d = null;
        try{
            d = new DataInputStream(new FileInputStream(path));

            //按存储顺序读取基本数据类型
            System.out.println(d.readInt());
            System.out.println(d.readBoolean());
            System.out.println(d.readDouble());
            System.out.println(d.readChar());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                d.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
