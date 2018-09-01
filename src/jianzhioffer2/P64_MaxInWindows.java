package jianzhioffer2;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author Zhang
 * @Date 2018/8/23 16:16
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *  {
 *      [2,3,4],2,6,2,5,1}，
 *      {2,[3,4,2],6,2,5,1}，
 *      {2,3,[4,2,6],2,5,1}，
 *      {2,3,4,[2,6,2],5,1}，
 *      {2,3,4,2,[6,2,5],1}，
 *      {2,3,4,2,6,[2,5,1]}
 *  }。
 */
public class P64_MaxInWindows {
    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> arrayList = maxInWindows2(num,3);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i)+",");
        }
    }

    /**
     * 方法一：时间复杂度O(n^2)
     *      （1）每次窗口向后滑动一位
     *      （2）每次取窗口内的元素的最大值
     *      （3）将最大值封装成ArrayList返回
     * 方法二：时间复杂度O(n^2)
     *      （1）使用一个队列来标记每个窗口最大值的下标
     * @param num
     * @param size
     * @return
     */
    public static ArrayList<Integer> maxInWindows2(int [] num, int size){
        if (num == null || num.length == 0 || size <= 0 || num.length < size) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        //双端队列，用来记录每个窗口的最大值下标
        LinkedList<Integer> qmax = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            //记录窗口中的最大值
            while (!qmax.isEmpty() && num[qmax.peekLast()] < num[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            //判断队首元素是否过期
            if(qmax.peekFirst() == i-size){
                qmax.pollFirst();
            }
            //当第一个窗口走完之后，之后的i每增加一步，都会产生一个新的窗口
            if (i >= size-1){
                result.add(num[qmax.peekFirst()]);
            }
        }
        return result;
    }

    public static ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (size<= 0){
            return arrayList;
        }
        for (int i = 0; i <= num.length - size; i++) {
            arrayList.add(maxOfArrayInWindow(num,i,i+size));
        }
        return arrayList;
    }

    public static int maxOfArrayInWindow(int [] array,int begin,int end){
        int max = Integer.MIN_VALUE;
        for (int i = begin; i < end ; i++) {
            max = Math.max(max,array[i]);
        }
        return max;
    }
}
