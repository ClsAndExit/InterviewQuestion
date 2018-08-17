package jiazhioffer2;

/**
 * @Author Zhang
 * @Date 2018/8/17 9:59
 *
 * 统计一个数字在排序数组中出现的次数。
 */
public class P37_GetNumberOfK {
    public static void main(String[] args) {
        int[] array = {3};
        System.out.println(GetNumberOfK(array,3));

    }


    /**
     * 题干意思是在一个有序数组中，找到数字k出现了多少次
     * 因为数组是有序的，所以k这个数如果在数组中出现了多次，那么这些个k一定是相邻的
     * 方法一：从头到尾遍历，时间复杂度o(n)
     * 方法二：利用快排的思想
     * @param array
     * @param k
     * @return
     */
    public static int GetNumberOfK(int [] array,int k){
        int number = 0;
        int begin = 0;
        int end = array.length-1;
        if(array.length == 1 && array[0] == k){
            number =1;
        }
        while (begin < end){
            if(array[begin] < k){
                begin++;
            }
            if (array[end] >k){
                end --;
            }
            if(array[begin] == array[end] && array[end] == k){
                number = end - begin + 1;
                break;
            }
        }
        return number;
    }
}
