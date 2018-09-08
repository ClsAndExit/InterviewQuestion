package designPatterns.staticFactoryMethod;

import designPatterns.factoryMethodANDabstractFactory.BetterPrinterFactory;

/**
 * @author Mr.Zhang
 * @create 2018-09-08 9:29
 * 客户端请求
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
        //创建OutputFactory
        OutputFactory of = new OutputFactory();
        //将Output对象传入，创建Computer对象
        Computer c = new Computer(of.getPrinterOutput("normal"));
        c.keyIn("建筑永恒之道");
        c.keyIn("建筑模式语言");
        c.print();

        c = new Computer(of.getPrinterOutput("better"));
        c.keyIn("建筑永恒之道");
        c.keyIn("建筑模式语言");
        c.print();

    }
}
