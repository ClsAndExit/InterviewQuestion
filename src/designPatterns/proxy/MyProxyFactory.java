package designPatterns.proxy;

import java.lang.reflect.Proxy;

/**
 * @author Mr.Zhang
 * @create 2018-09-08 12:32
 */
public class MyProxyFactory {
    //为指定target生成动态代理对象
    public static Object getProxy(Object target) throws Exception{
        //为指定target生成动态代理对象
        MyInvocationHandler handler = new MyInvocationHandler();

        //为MyInvocationHandler 设置target对象
        handler.setTarget(target);

        //创建并返回一个动态代理
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),handler);
    }
}
