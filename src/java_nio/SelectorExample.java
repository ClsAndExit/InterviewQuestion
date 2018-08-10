package java_nio;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.Selector;
import java.nio.channels.SelectionKey;
import java.nio.ByteBuffer;
import java.io.IOException;
import java.util.Set;
import java.util.Iterator;
import java.net.InetSocketAddress;
/**
 * 在Java NIO中，选择器(Selector)是可选择通道的多路复用器，可用作可以进入非阻塞模式的特殊类型的通道。
 * --它可以检查一个或多个NIO通道，并确定哪个通道准备好了可以进行通信，即读取或写入。
 *
 * 选择器(Selector)用于使用单个线程处理多个通道。 因此，它需要较少的线程来处理这些通道。
 * --线程之间的切换对于操作系统来说是昂贵的。 因此，使用它可以提高系统效率。
 */
public class SelectorExample {
    /**
     * 没看懂：https://www.yiibai.com/java_nio/java-nio-selector.html#article-start
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{
        // Get the selector
        Selector selector = Selector.open();
        System.out.println("Selector is open for making connection: " + selector.isOpen());
        // Get the server socket channel and register using selector
        ServerSocketChannel SS = ServerSocketChannel.open();
        InetSocketAddress hostAddress = new InetSocketAddress("localhost", 8080);
        SS.bind(hostAddress);
        SS.configureBlocking(false);
        int ops = SS.validOps();
        SelectionKey selectKy = SS.register(selector, ops, null);
        for (;;) {
            System.out.println("Waiting for the select operation...");
            int noOfKeys = selector.select();
            System.out.println("The Number of selected keys are: " + noOfKeys);
            Set selectedKeys = selector.selectedKeys();
            Iterator itr = selectedKeys.iterator();
            while (itr.hasNext()) {
                SelectionKey ky = (SelectionKey) itr.next();
                if (ky.isAcceptable()) {
                    // The new client connection is accepted
                    SocketChannel client = SS.accept();
                    client.configureBlocking(false);
                    // The new connection is added to a selector
                    client.register(selector, SelectionKey.OP_READ);
                    System.out.println("The new connection is accepted from the client: " + client);
                } else if (ky.isReadable()) {
                    // Data is read from the client
                    SocketChannel client = (SocketChannel) ky.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(256);
                    client.read(buffer);
                    String output = new String(buffer.array()).trim();
                    System.out.println("Message read from client: " + output);
                    if (output.equals("Bye Bye")) {
                        client.close();
                        System.out.println("The Client messages are complete; close the session.");
                    }
                }
                itr.remove();
            } // end of while loop
        } // end of for loop
    }
}
