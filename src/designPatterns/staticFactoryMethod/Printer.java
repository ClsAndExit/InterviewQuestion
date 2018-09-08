package designPatterns.staticFactoryMethod;

/**
 * @author Mr.Zhang
 * @create 2018-09-08 9:17
 *
 * output的一个实现
 * Class 'Printer' must either be declared abstract or implement abstract method 'getData(String)' in 'Output'
 * 必须将类'Printer'声明为abstract或在'Output'中实现抽象方法'getData（String）'
 */
public class Printer implements Output {
    private  String[] printData = new String[MAX_CACHE_LINE];
    //用以记录当前需要打印的作业数
    private  int dataNUm = 0;
    public void out(){
        //只要还有作业，继续打印
        while (dataNUm > 0){
            System.out.println("打印机打印：" + printData[0]);
            //把作业队列整体前移一位，并将剩余的作业数-1
            System.arraycopy(printData,1,printData,0,--dataNUm);
        }
    }

    public void getData(String msg){
        if (dataNUm >= MAX_CACHE_LINE){
            System.out.println("输出队列已满，添加失败");
        }else {
            //把打印数据添加到队列里，已保存数据的数量+1
            printData[dataNUm++] = msg;
        }
    }

}
