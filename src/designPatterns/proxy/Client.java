package designPatterns.proxy;

/**
 * @author Mr.Zhang
 * @create 2018-09-08 12:53
 *
 * 简单的代理模式就是将要访问的对象进行的封装，并且添加功能
 *
 * 借助于Java提供的Proxy和InvocationHandler，
 * 可以实现在运行时生成动态代理的功能，
 * 而动态代理对象就可以作为目标对象使用，而且增强了目标对象的功能。
 */
public class Client {
    public static void main(String[] args) throws Exception{
        //创建一个原始的Gun Panther对象
        Panther target = new GunPanther();

        //以指定的target来创建动态代理
        Panther panther = (Panther) MyProxyFactory.getProxy(target);


        System.out.println("不使用动态代理");
        target.run();
        target.info();
        System.out.println("使用动态代理");

        //调用代理对象的info() 和 run() 方法
        panther.info();
        panther.run();
    }
}
