package designPatterns.command;

/**
 * @author Mr.Zhang
 * @create 2018-09-08 13:20
 *
 * 具体的方法实现由接口的匿名实现类的实例来实现，
 * 因为该接口通常被称为命令接口，这种设计方式也被称为命令模式
 */
public class TestCommand {
    public static void main(String[] args) {
        ProcessArray pa = new ProcessArray();
        int[] target = {3,-4,6,4};
        //第一次处理数组，具体处理行为取决于Command对象
        pa.each(target, new Command() {
            @Override
            public void process(int[] target) {
                for (int tmp:target) {
                    System.out.println("迭代输出目标数组的元素：" + tmp);
                }
            }
        });

        System.out.println();
        System.out.println("------------------------");
        System.out.println();

        //第二次处理数组，具体处理行为取决于Command对象
        pa.each(target, new Command() {
            @Override
            public void process(int[] target) {
                int sum = 0;
                for (int tmp:target) {
                    sum+=tmp;
                }
                System.out.println("数组元素的总和是："+sum);
            }
        });
    }
}
