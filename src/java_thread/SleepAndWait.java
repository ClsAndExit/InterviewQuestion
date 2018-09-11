package java_thread;

/**
 * @author Mr.Zhang
 * @create 2018-09-10 8:47
 *
 * sleep()方法是属于Thread类的。而wait()方法，则是属于Object类的
 * sleep方法导致了程序暂停执行指定的时间，让出CPU给其他线程，但是他的监控状态依然保持着，
 *  指定的时间到了又会自动恢复运行状态。当调用sleep方法的过程中，线程不会释放对象锁。
 *
 * 当调用wait方法时，线程会放弃对象锁，进入等待此对象的等待锁定池，
 * 只有针对此对象调用notify方法后本线程才进入对象锁定池准备获取对象锁进入运行状态
 */
public class SleepAndWait {
    public static void main(String[] args) {
        new Thread(new Thread2()).start();

        new Thread(new Thread1()).start();
//        try{
//            Thread.sleep(3000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

    private static class Thread1 implements Runnable{
        @Override
        public void run() {
            synchronized (SleepAndWait.class){
                System.out.println("enter thread1...");
                System.out.println("thread1 is waiting...");
                try{
                    //调用wait方法，线程会放弃对象锁，进入等待此对象的等待锁定池
                    SleepAndWait.class.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("thread1 is going on ...");
                System.out.println("thread1 is over!!!");
            }
        }
    }

    private static class Thread2 implements Runnable{
        @Override
        public void run() {
            synchronized (SleepAndWait.class){
                System.out.println("enter thread2 ...");
                System.out.println("thread2 is sleep ...");
                //只有针对此对象调用notify方法后本线程才能进入对象锁定池准备获取对象锁进入运行状态
               // SleepAndWait.class.notify();


                //如果我们把代码：TestD.class.notify();给注释掉，
                // 即TestD.class调用了wait()方法，但是没有调用notify(),方法，则线程永远处于挂起状态。
                try{
                    //sleep()方法导致了程序暂停执行指定的时间，让出cpu该其他线程，
                    //但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态
                    //在调用sleep()方法的过程中，线程不会释放对象锁。
                    Thread.sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("thread2 is going on ...");
                System.out.println("thread2 is over!!!");
            }
        }
    }

}
