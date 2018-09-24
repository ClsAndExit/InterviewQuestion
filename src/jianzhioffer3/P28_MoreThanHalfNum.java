package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-24 10:43
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class P28_MoreThanHalfNum {
    public static void main(String[] args) {
        int [] arr = {1,2,3,2,2,2,5,4,2};
        System.out.println(Solution(arr));
    }

    /**
     * 如果一个数在数组中出现的次数超过数组长度的一半，那么这个数可以抵消掉所有其他的数字，并且还有剩余
     * @param arr
     * @return
     */
    public static int Solution(int[] arr){
        int target = arr[0];
        int time = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1]){
                time --;
                if (time == 0){
                    target = arr[i];
                    time ++;
                }
            }else {
                time++;
            }
        }
        time = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target){
                time++;
            }
        }
        return time > arr.length/2 ? target:0;
    }
}
