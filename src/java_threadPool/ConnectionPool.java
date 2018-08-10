package java_threadPool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * 首先看一下连接池的定义。它通过构造函数初始化连接的最大上限，通过一个双向队列
 * 来维护连接，调用方需要先调用fetchConnection(long)方法来指定在多少毫秒内超时获取连接，
 * 当连接使用完成后，需要调用releaseConnection(Connection)方法将连接放回线程池，示例如下：
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<Connection>();
    public ConnectionPool(int initialSize){
        if(initialSize > 0){
            for (int i = 0; i < initialSize; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection){
        if(connection!= null){
            synchronized (pool){
                //连接释放后需要进行通知，这样其他消费者能够感知连接池已经归还了一个链接
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    //在mills内无法获取到链接，将会返回null
    public Connection fetchConnection(long millis) throws InterruptedException{
        synchronized(pool){
            //完全超时
            if(millis <=0 ){
                while (pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }else{
                long future = System.currentTimeMillis()+millis;
                long remaining = millis;
                while(pool.isEmpty()&&remaining>0){
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                if(!pool.isEmpty()){
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }
}
