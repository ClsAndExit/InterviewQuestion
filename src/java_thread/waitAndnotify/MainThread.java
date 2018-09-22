package java_thread.waitAndnotify;

/**
 * @author Mr.Zhang
 * @create 2018-09-22 14:18
 */
public class MainThread {
    public static void main(String[] args) {
        Object o = new Object();//生成一个Object类型的对象
        MyThread myThread = new MyThread(o);//此处体现了对同一个对象的操作

        Thread t1 = new Thread(myThread);
        Thread t2 = new Thread(myThread);
        Thread t3 = new Thread(myThread);
        Thread t4 = new Thread(myThread);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        NotifyAll na = new NotifyAll(o);//此处体现了对同一个对象的操作

        Thread t = new Thread(na);

        //如果不调用的话t1--t4线程等待5秒钟之后自动唤醒
        //使用了之后等待三秒钟之后直接唤醒
        t.start();

    }
}
