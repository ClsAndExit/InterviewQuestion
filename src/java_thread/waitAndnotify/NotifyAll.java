package java_thread.waitAndnotify;

/**
 * @author Mr.Zhang
 * @create 2018-09-22 14:15
 */
public class NotifyAll implements Runnable {
    Object o;
    public NotifyAll(Object o){
        this.o = o;
    }
    @Override
    public void run(){
        synchronized (o){
            System.out.println("唤醒之前");
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            o.notifyAll();
            System.out.println("唤醒了。。。");
        }
    }
}
