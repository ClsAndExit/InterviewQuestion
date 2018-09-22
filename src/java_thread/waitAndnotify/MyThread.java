package java_thread.waitAndnotify;

/**
 * @author Mr.Zhang
 * @create 2018-09-21 21:29
 */
public class MyThread implements Runnable {
    Object o;

    public MyThread(Object o) {
        this.o = o;
    }

    @Override
    public void run() {
        synchronized (o) {
            System.out.println("等待中。。。。");
            try {
                o.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("等待结束。。。。");
        }
    }
}
