package jianzhioffer3;

import java_sorting.Util;

/**
 * @author Mr.Zhang
 * @create 2018-09-24 15:25
 *
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class P32_PrintMinNumber {
    public static void main(String[] args) {
        int[] array = {3,32,321};
        System.out.println(PrintMinNumber(array));
    }

    /**
     * 解题思路：
     * 1、三个数字排列成最小的数，这些数的大小需要重新定义
     * 2、3 + 32 > 32 + 3  332> 323  所以3 > 32
     * 3、将排好序的数组拼接到一起就可以
     * @param numbers
     * @return
     */
    public static String PrintMinNumber(int [] numbers){
        String s = "";
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length-i; j++) {
                if (compare(numbers,j-1,j)){
                    Util.swap(numbers,j-1,j);
                }
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            s+=numbers[i];
        }
        return s;
    }

    /**
     * array[i]>array[j]
     * @param array
     * @param i
     * @param j
     * @return
     */
    public static boolean compare(int[] array,int i,int j){
        boolean flag = false;
        String s1 = ""+array[i]+array[j];
        String s2 = ""+array[j]+array[i];

        if (s1.compareTo(s2) > 0) {
            flag = true;
        }
        return flag;
    }
}
