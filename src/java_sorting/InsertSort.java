package java_sorting;

import java.util.Arrays;

/**
 * @Author Zhang
 * @Date 2018/8/13 10:09
 *
 *直接插入排序是一种稳定排序 时间复杂度(O(n^2))
 * 将数组分为两部分，一部分是已经排好顺序的，另外一部分是还未经处理的部分
 * 在待排序部分选取一个数值（索引最小的那一个），按照数据大小插入到前面已经排好序的数组的适当位置，直到全部数据插入完毕为止。
 *
 */
public class InsertSort {
    public static void main(String[] args) {
        int [] array = {1,3,5,7,9,2,4,6,8,0};

        insertSort(array);

        System.out.println(Arrays.toString(array));
    }

    public static void insertSort(int [] array){
        for (int i = 1; i < array.length; i++) {
            //用来保存当前待插入的数值
            int key = array[i];
            //已经排好序的数组中的最后一个元素
            int j = i-1;
            //比较当前待插入的数和已经排好序的数，
            //如果待插入的数小于已经排好序的数组中的当前的数值，则将排好序的额数组中的当前值向后移动一位
            while (key<array[j]){
                array[j+1] = array[j];
                j--;
                if(j==-1){
                    break;
                }
            }
            //如果待插入数值大于当前的已排好序数组中的值，则将待插入数值插入到这个数值的后面
            //例如：现在的数组是：0 1 2 3 6 6 7 8 9
            //待插入的数值是 5
            //则当5和3比较的时候5>3，则将5插入到3的后面，即第一个6的位置（不用考虑这个6会不会被覆盖，因为这个6已经移动到后面了，
            // 也就是后面的那个6，前面的这个6的位置就是留给3的---如果3也大于5的话---现在被5给占用了）
            array[j+1] = key;
        }
    }
}
