package designPatterns.singleton;

/**
 * @author Mr.Zhang
 * @create 2018-09-08 8:59
 *
 */
public class Singleton {
    public static void main(String[] args) {
        //创建Singleton对象不能通过构造器，只能通过getInstance方法
        //创建Singleton对象不能通过构造器，只能通过getInstance方法
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        //判断是否为同一个
        System.out.println(s1==s2);
    }

    //使用一个变量来缓存曾经创建的对象
    private  static Singleton instance;
    //将构造器使用private修饰，隐藏该构造器
    private Singleton(){
        System.out.println("Singleton被构造");
    }

    /**
     * 提供一个静态方法，用于返回对象实例
     * 该方法可以加入自定义的控制，保证只产生一个实例对象
     * @return
     */
    public static Singleton getInstance(){
        //如果instance为null表示还不曾创建对象
        //如果不是null，则表明已经创建了，不会执行构造器
        if (instance == null){
            //创建一个对象实例，并将其缓存起来
            instance = new Singleton();
        }
        return instance;
    }
}
