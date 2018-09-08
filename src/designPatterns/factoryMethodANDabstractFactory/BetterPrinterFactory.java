package designPatterns.factoryMethodANDabstractFactory;

import designPatterns.staticFactoryMethod.BetterPrinter;
import designPatterns.staticFactoryMethod.Output;

/**
 * @author Mr.Zhang
 * @create 2018-09-08 9:37
 *
 * Interface expected here
 * 接口在这里预期
 */
public class BetterPrinterFactory implements OutputFactory {

    public Output getOutput(){
        //该工厂只负责生产Better Printer对象
        return new BetterPrinter();
    }
}
