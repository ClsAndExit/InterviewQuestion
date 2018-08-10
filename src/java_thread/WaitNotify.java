package java_thread;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 创建了两个线程——WaitThread和NotifyThread，前者检查flag值是否为false，如果符合要求，进行后续操作，否则在lock上等待，后者在睡眠了一段时间
 * 后对lock进行通知，示例如下所示。
 *
 * 等待/通知机制，是指一个线程A调用了对象O的wait()方法进入等待状态，而另一个线程B调用了对象O的notify()或者notifyAll()方法，线程A收到通知后从对象O的wait()方法返回，进而
 * 执行后续操作。上述两个线程通过对象O来完成交互，而对象上的wait()和notify/notifyAll()的关系就如同开关信号一样，用来完成等待方和通知方之间的交互工作。
 *
 * 等待/通知的相关方法
 *      方法名称                    描述
 *  notify()            通知一个在对象上等待的线程，使其从wait()放大返回，而返回的前提是该线程获取到了对象的锁
 *  notifyAll()         通知所有等待在该对象上的线程
 *  wait()              调用该方法的线程进入WAITINT状态， 只有等待另外线程的通知或被中断才会返回，需要注意，调用wait()之后，会释放对象的锁
 *  wait(long)          超时等待一段时间，这里的参数时间是毫秒，也就是等待长达毫秒，如果没有通知就超时返回
 *  wait(long,int)      对于超时时间更细粒度的控制，可以达到纳秒
 *
 *  上述例子主要说明了调用wait()、notify()以及notifyAll()时需要注意的细节，如下。
 * 1）使用wait()、notify()和notifyAll()时需要先对调用对象加锁。
 * 2）调用wait()方法后，线程状态由RUNNING变为WAITING，并将当前线程放置到对象的等待队列。
 * 3）notify()或notifyAll()方法调用后，等待线程依旧不会从wait()返回，需要调用notify()或notifAll()的线程释放锁之后，等待线程才有机会从wait()返回。
 * 4）notify()方法将等待队列中的一个等待线程从等待队列中移到同步队列中，而notifyAll()方法则是将等待队列中所有的线程全部移到同步队列，被移动的线程状态由WAITING变为BLOCKED。
 * 5）从wait()方法返回的前提是获得了调用对象的锁。
 *
 * 从上述细节中可以看到，等待/通知机制依托于同步机制，其目的就是确保等待线程从wait()方法返回时能够感知到通知线程对变量做出的修改。
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args){
        Thread waitThread = new Thread(new Wait(),"WaitThread");
        waitThread.start();
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        Thread notifyThread = new Thread(new Notify(),"NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable{
        @Override
        public void run() {
            //加锁，拥有lock的monitor
            synchronized (lock){
                //当条件不满足时，继续wait,同时释放了lock的锁
                while (flag){
                    try{
                        System.out.println(Thread.currentThread() + " flag is true. wait @" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                //条件满足时，完成工作
                System.out.println(Thread.currentThread() + " flag is false. running @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable{
        @Override
        public void run() {
            //加锁，拥有lock的monitor
            synchronized (lock){
                //获取lock的锁，然后进行通知，通知时不会释放lock的锁
                //直到当前线程释放了lock的锁，Wait Thread才能从wait方法中返回
                System.out.println(Thread.currentThread() + " hold lock. notify @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                try{
                    TimeUnit.SECONDS.sleep(5);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            //为了明显的看见第3行和第4行输出的顺序互换加入这一段等待
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
            //再次加锁
            synchronized (lock){
                System.out.println(Thread.currentThread() + " hold lock again. sleep @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                try{
                    TimeUnit.SECONDS.sleep(5);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
/**
 * 运行结果
 * Thread[WaitThread,5,main] flag is true. wait @19:37:43
 * Thread[NotifyThread,5,main] hold lock. notify @ 19:37:44
 * Thread[NotifyThread,5,main] hold lock again. sleep @ 19:37:49
 * Thread[WaitThread,5,main] flag is false. running @ 19:37:54
 *
 * 或
 * Thread[WaitThread,5,main] flag is true. wait @19:51:03
 * Thread[NotifyThread,5,main] hold lock. notify @ 19:51:04
 * Thread[WaitThread,5,main] flag is false. running @ 19:51:09
 * Thread[NotifyThread,5,main] hold lock again. sleep @ 19:51:09
 *
 * 因为第3行和第4行输出的顺序可能会互换
 */
