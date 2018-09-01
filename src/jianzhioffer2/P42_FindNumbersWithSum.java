package jianzhioffer2;

import java.util.ArrayList;

/**
 * @Author Zhang
 * @Date 2018/8/17 18:50
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * */
public class P42_FindNumbersWithSum {
    public static void main(String[] args) {
        int [] array ={-2,-1,0,1,2,3,4,5,6,7,8,9,10,11};
        int sum = 9;
        ArrayList<Integer> list = FindNumbersWithSum(array,sum);
        for (Integer answer:list) {
            System.out.println(answer.intValue());
        }
    }

    /**
     * 问题分析：
     * 先考虑全都为正数的情况
     * 如果有两对数值相加的结果都等于一个sum
     * 那么这两对数中，差值大的乘积小
     * 如果有负数或0存在，同样符合上述规律
     *
     * 方法一：左右夹逼
     *        （1）定义两个游标指针分别放在数组的头部和尾部
     *        （2）判断当前两个数的和是否为sum，如果满足条件则返回
     *        （3）如果两数的和大于sum，则high--，反之low++
     * @param array
     * @param sum
     * @return
     * 输出描述:
     * 对应每个测试案例，输出两个数，小的先输出。
     */
    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (array.length<2){
            return list;
        }
        int low = 0;
        int high = array.length-1;
        while (low<high){
            int sumOfCurrent = array[low]+array[high];
            if (sumOfCurrent == sum){
                list.add(array[low]);
                list.add(array[high]);
                break;
            }else if (sumOfCurrent < sum){
                low++;
            }else {
                high--;
            }
        }
        return list;
    }
}
