package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-24 20:56
 * <p>
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 */
public class P37_GetNumberOfK {
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 2, 2, 2, 3, 3, 4, 5, 5, 6, 7, 8, 89};
        System.out.println(GetNumberOfK(array, 2));
    }

    /**
     * 解题思路：
     * 1、遍历一遍统计
     * 2、首位同时进行比较查找
     * 3、二分查找
     *
     * @param array
     * @param k
     * @return
     */
    public static int GetNumberOfK(int[] array, int k) {
        int length = array.length;
        if (length == 0){
            return 0;
        }
        int firstK = getFirstK(array,k,0,length-1);
        int lastK = getLastK(array,k,0,length-1);

        if (firstK != -1 && lastK != -1){
            return lastK-firstK+1;
        }
        return 0;
    }

    //递归写法
    public static int getFirstK(int[] array, int k, int start, int end) {
        if (start > end){
            return -1;
        }
        int mind =( start + end)>>1;
        if (array[mind] > k){
            return getFirstK(array,k,start,mind-1);
        }else if(array[mind] < k){
            return getFirstK(array,k,mind+1,end);
        }else if (mind-1 >=0 && array[mind-1] == k){
            return getFirstK(array,k,start,mind-1);
        }else {
            return mind;
        }
    }

    //循环写法
    public static int getLastK(int[] array, int k, int start, int end) {
        int length = array.length;
        int mind = (start+end)>>1;
        while (start <= end){
            if (array[mind] > k){
                end = mind-1;
            }else if (array[mind] < k){
                start =mind+1;
            }else if (mind+1< length && array[mind+1] == k){
                start = mind+1;
            }else {
                return mind;
            }
            mind = (start+end)>>1;
        }
        return -1;
    }
}
