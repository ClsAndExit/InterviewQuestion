package java_threadPool;


import sun.security.x509.EDIPartyName;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 通过一个示例来测试简易数据库连接池的工作情况，模拟客户端ConnectionRunner获取、使用、最后释放连接的过程，
 * 当它使用时连接将会增加获取到连接的数量，反之，将会增加未获取到连接的数量
 *
 *
 * 在资源一定的情况下（连接池中的10个连接），随着客户端
 * 线程的逐步增加，客户端出现超时无法获取连接的比率不断升高。虽然客户端线程在这种超
 * 时获取的模式下会出现连接无法获取的情况，但是它能够保证客户端线程不会一直挂在连接
 * 获取的操作上，而是“按时”返回，并告知客户端连接获取出现问题，是系统的一种自我保护机
 * 制。数据库连接池的设计也可以复用到其他的资源获取的场景，针对昂贵资源（比如数据库连
 * 接）的获取都应该加以超时限制。
 *
 *
 */
public class ConnectionPoolTest {
    static ConnectionPool pool = new ConnectionPool(10);
    //保证所有ConnectionRunner能够同时开始
    //CountDownLatch是一个同步工具类，它允许一个或多个线程一直等待，直到其他线程执行完后再执行。例如，
    // 应用程序的主线程希望在负责启动框架服务的线程已经启动所有框架服务之后执行。
    static CountDownLatch start = new CountDownLatch(1);
    //main线程会等待所有Connection Runner结束后才能继续执行
    static CountDownLatch end;

    public static void main(String[] args) throws Exception{
        //线程数量，可以修改线程数量进行观察
        int threadCount = 20;
        end = new CountDownLatch(threadCount);
        int count =20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count,got,notGot),
                    "ConnectionRunnerThread");
            thread.start();
        }

        start.countDown();
        end.await();
        System.out.println("total invoke: " + (threadCount * count));
        System.out.println("got connection: " + got);
        System.out.println("not got connection " + notGot);
    }


    static class ConnectionRunner implements Runnable{
        int count ;
        AtomicInteger got;
        AtomicInteger notGot;
        public ConnectionRunner(int count,AtomicInteger got,AtomicInteger notGot){
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try{
                start.await();
            }catch (Exception e){
                e.printStackTrace();
            }
            while (count>0){
                try{
                    //从线程池中获取连接，如果1000毫秒内无法获取，将会返回null
                    //分别统计链接获取的数量got和未获取的数量notGot
                    Connection connection = pool.fetchConnection(1000);
                    if(connection != null){
                        try{
                            connection.createStatement();
                            connection.commit();
                        }finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    }else {
                        notGot.incrementAndGet();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    count--;
                }
            }
            end.countDown();
        }
    }

}
