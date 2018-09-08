package designPatterns.command;

/**
 * @author Mr.Zhang
 * @create 2018-09-08 13:19
 */
public class ProcessArray {
    //定义一个each()方法，用于处理数组
    public void each(int[] target,Command command){
        command.process(target);
    }
}
