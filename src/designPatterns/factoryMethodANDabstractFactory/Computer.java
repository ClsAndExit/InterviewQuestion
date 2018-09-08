package designPatterns.factoryMethodANDabstractFactory;

import designPatterns.staticFactoryMethod.Output;

/**
 * @author Mr.Zhang
 * @create 2018-09-08 9:49
 */
public class Computer {
    private Output out;
    public Computer(Output out){
        this.out = out;
    }

    //定义一个模拟字符串输入的方法
    public void keyIn(String msg){
        out.getData(msg);
    }

    //定义一个模拟打印的方法
    public void print(){
        out.out();
    }

    public static void main(String[] args) {

        System.out.println("工厂方法模式");
        //创建OutputFactory
//        OutputFactory of = new BetterPrinterFactory();
        OutputFactory of = new PrinterFactory();
        //将Output对象传入，创建Computer对象
        Computer c = new Computer(of.getOutput());
        c.keyIn("建筑永恒之道");
        c.keyIn("建筑模式语言");
        c.print();

        System.out.println("抽象工厂方法");
        OutputFactory f1 = OutputFactoryFactory.getOutputFactory("better");
        Computer c1 = new Computer(f1.getOutput());
        c1.keyIn("建筑永恒之道");
        c1.keyIn("建筑模式语言");
        c1.print();
    }
}
