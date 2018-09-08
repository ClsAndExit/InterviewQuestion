package designPatterns.factoryMethodANDabstractFactory;

/**
 * @author Mr.Zhang
 * @create 2018-09-08 10:03
 * 为了解决客户端代码与不同工厂类耦合的问题。
 * 在工厂类的基础上再增加一个工厂类，该工厂类不制造具体的被调用对象，而是制造不同工厂对象
 */
public class OutputFactoryFactory {
    //仅定义一个方法用于返回输出设备
    public static OutputFactory getOutputFactory(String type){
        if (type.equalsIgnoreCase("better")){
            return new BetterPrinterFactory();
        }else {
            return new PrinterFactory();
        }
    }
}
