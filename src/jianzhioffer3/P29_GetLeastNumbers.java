package jianzhioffer3;

import java_sorting.Util;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Mr.Zhang
 * @create 2018-09-24 10:51
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4,。
 */
public class P29_GetLeastNumbers {
    public static void main(String[] args) {
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> list = solution3(array, 4);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");
        }
    }

    /**
     * 求解最小的k个数
     * 解题思路：
     * 1、全排序
     * 2、冒泡思想取前K个
     * 3、堆排序（建堆初始堆大小为K）
     *
     * @param array
     * @param k
     * @return
     */
    public static ArrayList<Integer> solution1(int[] array, int k) {
        Arrays.sort(array);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            list.add(array[i]);
        }
        return list;
    }

    public static ArrayList<Integer> solution2(int[] array, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    Util.swap(array, j + 1, j);
                }
            }
            list.add(array[array.length - 1 - i]);
        }
        return list;
    }

    public static ArrayList<Integer> solution3(int[] array, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (array == null || array.length <= 0 || array.length <= k) {
            return list;
        }
        //构建最大堆
        for (int i = k / 2 - 1; i >= 0; i--) {
            buildMaxHeap(array, i, k - 1);
        }
        int tmp;
        for (int i = k; i < array.length; i++) {
            if (array[i] < array[0]) {
                Util.swap(array, i, 0);
                buildMaxHeap(array, 0, k - 1);
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(array[i]);
        }
        return list;
    }

    public static void buildMaxHeap(int[] input, int pos, int length) {
        int temp;
        int child = 0;
        for (temp = input[pos]; 2 * pos + 1 <= length; pos = child) {
            child = 2* pos+1;
            if (child < length && input[child] < input[child+1]) {
                child++;
            }
            if (input[child] >temp){
                input[pos] = input[child];
            }else {
                break;
            }
        }
        input[pos] = temp;
    }
}
