package java_nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Listen for connections and tell callers what time it is.
 * Demonsrates NIO socket channel (accepting and writing),
 * buffer handling ,charsets, and regular expressions.
 */
public class TimeServer {
    //The potr we'll actually use
    private static int port = 8125;

    //Charset and encoder fofr US-ASCII
    //
    private static Charset charset = Charset.forName("US-ASCII");
    private static CharsetEncoder encoder = charset.newEncoder();

    //Direct byte buffer for writing
    private static ByteBuffer dbuf = ByteBuffer.allocateDirect(1024);

    //open and bind the server-socket channel
    //
    private static ServerSocketChannel setup()throws IOException{
        ServerSocketChannel ssc = ServerSocketChannel.open();
        String host = InetAddress.getLocalHost().getHostAddress();
        System.out.println("Listen at Hose:"+host+",port:"+port);
        InetSocketAddress isa = new InetSocketAddress(host,port);
        ssc.socket().bind(isa);
        return ssc;
    }

    //Server the next request to come in on the given channel
    //
    private static void server(ServerSocketChannel ssc) throws  IOException{
        SocketChannel sc = ssc.accept();
        try{
            String now = new Date().toString();
            sc.write(encoder.encode(CharBuffer.wrap(now+"\r\n")));
            sc.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            sc.close();
        }
    }

    public static void main(String[] args) throws IOException{
        if(args.length>1){
            System.err.println("Usage:java TimeServer [port]");
            return;
        }

        //If the first argument is a string of digits then we take that
        //to be the port number
        if((args.length==1)&&Pattern.matches("[0-9]+",args[0])){
            port = Integer.parseInt(args[0]);
        }

        ServerSocketChannel ssc = setup();
        for(;;)
            server(ssc);
    }
}
