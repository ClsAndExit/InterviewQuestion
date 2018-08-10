package java_thread;

import java.util.concurrent.TimeUnit;

/**
 * 示例在执行过程中，main线程通过中断操作和cancel()方法均可使CountThread得以终止。
 * 这种通过标识位或者中断操作的方式能够使线程在终止时有机会去清理资源，而不是武断地
 * 将线程停止，因此这种终止线程的做法显得更加安全和优雅。
 */
public class ShutDown {
    public static void main(String[]args) throws Exception{
        Runner one = new Runner();
        Thread countThread = new Thread(one,"CountThread");
        countThread.start();
        //睡眠1秒，main线程对Count Thread进行中断，使Count Thread能够感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();

        Runner two = new Runner();
        countThread = new Thread(two,"CountThread");
        countThread.start();
        // 睡眠1秒，main线程对Runner two进行取消，使CountThread能够感知on为false而结束
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }

    private static class Runner implements Runnable{
        private  long i;
        private volatile boolean on = true;

        @Override
        public void run() {
            while(on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            Util.print("Count i = "+i);
        }
        public void cancel(){
            on = false;
        }
    }
}
