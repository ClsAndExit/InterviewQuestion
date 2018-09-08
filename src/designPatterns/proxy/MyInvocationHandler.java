package designPatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Mr.Zhang
 * @create 2018-09-08 12:44
 *
 * 增强代理的功能
 */
public class MyInvocationHandler implements InvocationHandler {
    //需要被代理的对象
    private Object target;
    public void setTarget(Object target){
        this.target = target;
    }

    //执行动态代理对象的所有方法时，都会被替换成执行如下的invoke（调用）方法
    public Object invoke(Object proxy, Method method,Object[] args) throws  Exception{
        TxUtil tx = new TxUtil();
        //执行TxUtil中的beginTX
        tx.beginTx();

        //以target为主调来执行method方法
        Object result = method.invoke(target,args);

        //执行TxUtil中的endTX
        tx.endTx();

        return result;
    }
}
