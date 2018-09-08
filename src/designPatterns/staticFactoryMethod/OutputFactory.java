package designPatterns.staticFactoryMethod;

/**
 * @author Mr.Zhang
 * @create 2018-09-08 9:28
 * 简单工厂类
 */
public class OutputFactory {
    public Output getPrinterOutput(String type){
        if (type.equalsIgnoreCase("better")){
            return new BetterPrinter();
        }else {
            return new Printer();
        }
    }
}
