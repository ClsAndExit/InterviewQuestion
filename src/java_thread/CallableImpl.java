package java_thread;

import java.sql.SQLOutput;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author Mr.Zhang
 * @create 2018-09-20 21:43
 *
 * 参考网址：
 * https://www.cnblogs.com/frinder6/p/5507082.html
 *
 */
public class CallableImpl implements Callable<String> {

    private String acceptStr;
    public CallableImpl(String acceptStr){
        this.acceptStr = acceptStr;
    }

    @Override
    public String call() throws Exception{
        Thread.sleep(1000);
        return this.acceptStr+" append some chars ang return it!";
    }

    public static void main(String[] args) throws Exception {
        Callable<String> callable = new CallableImpl("my callable test!");
        FutureTask<String> task = new FutureTask<>(callable);
        long beginTime = System.currentTimeMillis();
        new Thread(task).start();

        String result = task.get();
        long endTime = System.currentTimeMillis();
        System.out.println("hello :" + result);
        System.out.println("cast:"+(endTime-beginTime)/1000+"seconds");
    }
}
