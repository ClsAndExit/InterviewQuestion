package designPatterns.proxy;

/**
 * @author Mr.Zhang
 * @create 2018-09-08 12:35
 */
public class TxUtil {
    //第一个拦截器方法，模拟事务开始
    public void beginTx(){
        System.out.println("========模拟事务开始=======");
    }

    //第二个拦截器方法，模拟事务结束
    public void endTx(){
        System.out.println("========模拟事务结束=======");
    }
}
