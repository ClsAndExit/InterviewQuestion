package java_sorting;

import java.util.Arrays;

/**
 * @Author Zhang
 * @Date 2018/8/13 10:58
 *
 * 希尔排序属于不稳定排序 
 *
 * 参考：https://blog.csdn.net/china_zoujinyong/article/details/14484575#commentBox
 * 希尔排序是一种插入排序，又称作缩小增量排序，是对直接插入排序算法的改进
 * 先取一个小于N的整数M作为第一增量，将数据分为M组。把所有距离为M的倍数的记录放在同一组中，先在各组内部进行直接插入排序
 * 然后取第二个增量重复上述的分组和排序，直至所取得增量为1，即所有的记录放在同一组中进行直接插入排序为止，该方法实际上是一种分组插入方法
 *
 * 很明显插入排序的时间复杂度T(n) = O(n*n);从插入的排序过程可以看出，主要的时间消耗在寻找有序队列中的位置上，
 * 那么排序要加快的基本原则之一，是让后一次的排序进行时，尽量利用前一次排序后的结果，
 * 以加快排序的速度，Shell排序法即是基于此一概念来改良插入排序法。
 *
 *
 */
public class ShellSort {
    public static void main(String[] args) {
        int [] array = {1,3,51,7,9,2,4,6,8,0};

        shellSort(array);

        System.out.println(Arrays.toString(array));
    }
    public static void shellSort(int[] array){
        int n = array.length;
        //定义增量
        int h;
        //增量每次变为原来的一半
        for (h = n/2; h>0; h/=2) {
            for (int i = h; i < n; i++) {
                for (int j = i-h; j >=0 ; j-=h) {
                    if(array[j]>array[j+h]){
                        Util.swap(array,j,j+h);
                    }
                }
            }
        }
    }
}
