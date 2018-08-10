package java_thread;


import java.util.concurrent.TimeUnit;

/**
 * 如果一个线程A执行了thread.join()语句，其含义是：当前线程A等待thread线程终止之后才从thread.join()返回。
 * 线程Thread除了提供join()方法之外，还提供了join(long millis)和join(long millis,int nanos)两个具备超时特性的方法。
 * 这两个超时方法表示，如果线程thread在给定的超时时间里没有终止，那么将会从该超时方法中返回。
 *
 *
 * 所示的例子中，创建了10个线程，编号0~9，每个线程调用前一个线程的join()方法，也就是线程0结束了，线程1才能
 * 从join()方法中返回，而线程0需要等待main线程结束。
 *
 */
public class Join {
    public static void main(String[] args)throws Exception{
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous),String.valueOf(i));
            thread.start();
            previous  = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }

    static class Domino implements Runnable{
        private Thread thread;
        public Domino (Thread thread){
            this.thread = thread;
        }

        @Override
        public void run() {
            try{
                //thread.join(1000);
                thread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            //currentThread().getName()//获取当前线程名称
            //使用Thread.currentThread().getName()和使用this.getName()和对象实例.getName(),都可以得到线程的名称,
            // 但是使用this调用getName()方法只能在本类中，而不能在其他类中，更不能在Runnable接口中，所以只能使用
            // Thread.currentThread().getName()获取线程的名称，否则会出现编译时异常。
            Util.print(Thread.currentThread().getName()+"terminate.(终止)");
        }
    }
}
