package jiazhioffer2;

import java.util.Arrays;

/**
 * @Author Zhang
 * @Date 2018/8/16 15:47
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 输入描述：
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 	对于%50的数据,size<=10^4
 * 	对于%75的数据,size<=10^5
 * 	对于%100的数据,size<=2*10^5
 *
 * 	示例1
 * 输入
 * 1,2,3,4,5,6,7,0
 * 输出
 * 7
 *
 */
public class P35_InversePairs {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(array));
    }

    /**
     * 方法一：时间复杂度o(n^2) 嵌套循环，拿当前值与数组中在它后面的所有值进行比较，
     *          如果大于后面的值，则为一个逆序对
     * 方法二：空间换时间(暂时没有找到比较好的方法，先不去考虑了)
     * @param array
     * @return
     */
    public static int InversePairs(int[] array){
        return -1;
    }
}
