package java_sorting;

import java.util.Arrays;

/**
 * @Author Zhang
 * @Date 2018/8/13 8:05
 *
 * 冒泡排序：时间复杂度（O(n^2)） 属于稳定排序
 * 再排序算法的分类中属于交换排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int [] array = {1,3,5,7,9,2,4,6,8,0};

        bubbleSort(array);

        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[]array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if(array[i]>array[j]){
                    Util.swap(array,i,j);
                }
            }
        }
    }

}
