package java_thread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 创建了printThread，它用来接受main线程的输入，任何main线程的输入均通过PipedWriter写入，而printThread在另一端通过PipedReader将内容读出并打印。
 *
 * 对于Piped类型的流，必须先要进行绑定，也就是调用connect()方法，如果没有将输入/输出流绑定起来，对于该流的访问将会抛出异常
 */
public class Piped {
    public static void main(String[] args)throws IOException{
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        //将输出流和输入流进行连接，否则在使用时会抛出IOException
        out.connect(in);
        Thread printThread = new Thread(new Print(in),"PrintThread");
        printThread.start();
        int receive = 0;
        try{
            while((receive = System.in.read())!=-1){
                out.write(receive);
            }
        }catch (IOException  e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

    static class Print implements Runnable{
        private PipedReader in;
        public Print(PipedReader in){
            this.in = in;
        }
        @Override
        public void run() {
            int receive = 0;
            try{
                while((receive = in.read())!=-1){
                    Util.print((char)receive);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
