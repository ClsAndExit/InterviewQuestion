package java_sorting;

import java.util.Arrays;

/**
 * @Author Zhang
 * @Date 2018/8/13 14:59
 *
 * 直接选择排序是一种不稳定的排序算法
 * 基本思想：
 * 第一次从R[0]~R[n-1]中选取最小值，与R[0]交换，
 * 第二次从R[1]~R[n-1]中选取最小值，与R[1]交换，
 * ….，
 * 第i次从R[i-1]~R[n-1]中选取最小值，与R[i-1]交换，
 * …..，
 * 第n-1次从R[n-2]~R[n-1]中选取最小值，与R[n-2]交换，
 * 共通过n-1次，得到一个从小到大排列的有序序列。
 *
 *
 */
public class SelectSort {
    public static void main(String[] args) {
        int [] array = {1,3,51,7,9,2,4,6,8,0};

        selectSort(array);

        System.out.println(Arrays.toString(array));
    }

    public static void selectSort(int [] array){
        for (int i = 0; i < array.length; i++) {
            int mainIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j]<array[mainIndex]){
                    mainIndex = j;
                }
            }
            if(mainIndex != i){
                Util.swap(array,mainIndex,i);
            }
        }
    }
}
