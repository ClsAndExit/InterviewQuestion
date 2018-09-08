package designPatterns.proxy;

/**
 * @author Mr.Zhang
 * @create 2018-09-08 12:31
 */
public class GunPanther implements Panther{
    @Override
    public void info(){
        System.out.println("我是一只猎豹");
    }

    @Override
    public void run() {
        System.out.println("我奔跑迅速");
    }
}
