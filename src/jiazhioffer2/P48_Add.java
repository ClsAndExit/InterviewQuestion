package jiazhioffer2;

import java.util.Arrays;

/**
 * @Author Zhang
 * @Date 2018/8/18 20:53
 */
public class P48_Add {
    public static void main(String[] args) {
        System.out.println( add1(0,2));
    }

    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     * @param num1
     * @param num2
     * @return
     * 使用这种方法还需要判断正负，而且还使用了++，--不太符合题意
     */
    public static int add(int num1,int num2){
        int sum =0;
        for (int i = 0; i < num1; i++) {
            num2++;
        }
        sum = num2;
        return sum;
    }

    /**
     *思路：位运算
     * 两个数异或：相当于每一位相加，而不考虑进位；
     * 两个数相与，并左移一位：相当于求得进位；
     * 将上述两步的结果相加
     *
     * 链接：https://www.nowcoder.com/questionTerminal/59ac416b4b944300b617d4f7f111b215
     * 来源：牛客网
     *
     * 同样我们可以用三步走的方式计算二进制值相加： 5-101，7-111 第一步：相加各位的值，不算进位，得到010，二进制每位相加就相当于各位做异或操作，101^111。
     *
     * 第二步：计算进位值，得到1010，相当于各位做与操作得到101，再向左移一位得到1010，(101&111)<<1。
     *
     * 第三步重复上述两步， 各位相加 010^1010=1000，进位值为100=(010&1010)<<1。
     *      继续重复上述两步：1000^100 = 1100，进位值为0，跳出循环，1100为最终结果。
     * @param num1
     * @param num2
     * @return
     */
    public static int add1(int num1,int num2){
        while( num2!=0 ){
            int sum = num1 ^ num2;
            int carray = (num1 & num2) << 1;
            num1 = sum;
            num2 = carray;
        }
        return num1;
    }
}
