package java_socket;

import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.Executors;

/**
 * @author Mr.Zhang
 * @create 2018-09-22 16:31
 */
public class Server extends Thread{
    ServerSocket serverSocket ;//声明套接字
    //Vector是线程安全的，Array List是非线程安全的
    //构造函数中的两个参数分别是初始容量和增长增量
    static Vector userOnLine = new Vector(0,1);//存储在线用户信息
    static Vector chatGainedMessage = new Vector(0,1);//存储在线聊天信息与留言
    static Vector userAdvice = new Vector(0,1);

    public Server(int port){
        chatGainedMessage.addElement("");
        try{
            serverSocket = new ServerSocket(port);
        }catch (Exception e){
            fail(e,"无法启动服务器！");
        }
        System.out.println("服务器启动成功。。。。。。");

        this.start();//启动server线程
    }

    public void run(){
        try{
            while (true){
                //等待客户端连接端口
                Socket client = serverSocket.accept();
                System.out.println("服务器监听。。。。");
                Connection connect = new Connection(client);

            }
        }catch (Exception e){
            fail(e,"Not listening");
        }
    }

    public static void  fail(Exception e ,String str){
        System.out.println(str+","+e);
    }
}
