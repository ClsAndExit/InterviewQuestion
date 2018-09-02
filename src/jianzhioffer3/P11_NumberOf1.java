package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-02 19:21
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class P11_NumberOf1 {
    public static void main(String[] args) {
        int n = -5;
        System.out.println(NumberOf(n));
    }

    /**
     * 方法一：不需要判断正负，每一次-1都会在下一个1出现之前所有的符号变号，这样操作了多少次就知道有多少个1了
     * 方法二：将负数转换为正数，然后同意通过移位方法进行计算
     *
     * @param n
     * @return
     */
    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static int NumberOf(int n) {
        int count = 0;
        if (n < 0) {
            //变化之后 （这时的）n != -（原来的）n 这一点一定要注意
            n = n & 0x7FFFFFFF;
            count ++;//符号位
        }
        while (n != 0) {
            count += n & 1;
            n = n >> 1;
        }
        return count;
    }
}
