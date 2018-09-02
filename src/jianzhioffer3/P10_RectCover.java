package jianzhioffer3;

import jianzhioffer2.Fibonacci;

/**
 * @author Mr.Zhang
 * @create 2018-09-02 19:08
 *
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class P10_RectCover {
    public static void main(String[] args) {
        int target = 10;
        System.out.println(RectCover(target));
    }

    /**
     * 解题思路：
     * 通过归纳可以发现摆放方式符合斐波那契数列
     * 当n>= 2时
     * 第一块竖着放则后面有f(n-1)种摆放方式
     * 第一块横着放则第二块也必须横着放，后面还有f(n-2)种摆放方式
     * @param target
     * @return
     */
    public static int RectCover(int target){
        return Fibonacci.Fibonacci(target);
    }
}
