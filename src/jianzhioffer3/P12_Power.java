package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-02 19:38
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class P12_Power {
    public static void main(String[] args) {
        double base = 3.3;
        int exponent = -4;
        System.out.println(Power(base, exponent));
    }

    /**
     * 方法一：o(n)解法，直接乘n次
     * 方法二：利用公式【a^b = a^b1 * a^b2 * a^b3(其中 b = b1+b2+b3)】对n进行简化：
     * （1）首先需要判断exponent的正负，如果为负则转化为正数
     * （2）2^5 = 2^2^2*2
     *
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent) {
        double result = base;
        boolean flag = false;
        if (base == 0) {
            result = 0;
            return result;
        }
        if (exponent == 0) {
            result = 1;
            return result;
        }
        if (exponent < 0) {
            exponent = -exponent;
            flag = true;
        }
        while (exponent != 0) {
            result *= base;
            exponent = exponent >> 1;
        }
        if (flag) {
            return 1 / result;
        } else
            return result;
    }
}
