package onlineWrittenTest.Keep;

/**
 * @Author Zhang
 * @Date 2018/8/23 18:24
 */
public class Main {
    public static void main(String[] args) {
        /**
         * 1、烧绳子计时问题
         * https://blog.csdn.net/fbz123456/article/details/51024299
         *
         * 2、hash线性探测方法解决冲突
         *
         * 3、代码验证如下
         *
         * 4、经典条件概率问题：男概率12%，女概率8%，现在在相同数量的男女中选出一人，是X，则是男性的概率为多少
         *
         * 5、在Linux服务器上面，把文本文件中的空格全部去掉使用什么命令
         *
         * 7、for() 中的几个位置的执行顺序
         *
         * 8、9、均为操作性同相关问题，大多在进程调度方面
         *
         * 10、射击命中率为90%，现在射击100次，没射中的需要补射两次，已知补射的次数为X，则X的期望为多少
         *
         * 11、堆数据结构主要使用数组进行存储，有效最小堆的数组是什么样的
         *
         * 编程问题：1、活动时间按排问题
         * 2、字符串，回文，字串（问题描述过于复杂，没记）
         * 3、在一个0 1矩阵中，1出现的连续区域的最大面积
         */

        //选择题3题验证代码
        int number = 999999;
        int count =0 ;
        while (number>0){
            count++;
            number = number&(number-1);
        }
        System.out.println(count);
    }
}
