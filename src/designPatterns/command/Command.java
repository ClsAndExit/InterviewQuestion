package designPatterns.command;

/**
 * @author Mr.Zhang
 * @create 2018-09-08 13:17
 */
public interface Command {
    //接口里定义的process（处理）方法用于封装“处理行为”
    void process (int[] target);
}
