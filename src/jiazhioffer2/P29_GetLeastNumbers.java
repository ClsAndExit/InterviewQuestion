package jiazhioffer2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P29_GetLeastNumbers {
    public static void main(String[] args) {
        int [] inputArray = {0,1,123,3,4,5,6,7,8,9};

        System.out.println(GetLeastNumbers_Solution(inputArray,4).toString());
    }

//    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
//        ArrayList<Integer> numlist = new ArrayList<Integer>();
//        //冒泡思想O(N*K)
//        for (int i = 0; i <k; i++) {
//            for (int j = 0; j <input.length-i-1 ; j++) {
//                if(input[j]<input[j+1]){
//                    swap(input,j,j+1);
//                }
//            }
//            numlist.add(input[input.length-1-i]);
//        }
//
//        //堆
//
//        return numlist;
//    }
//    public static void swap(int[] chars,int i,int j){
//        int temp = chars[i];
//        chars[i] = chars[j];
//        chars[j] = temp;
//    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if(k>length||k==0){
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < length; i++) {
            if(maxHeap.size()!=k){
                maxHeap.offer(input[i]);
            }else if(maxHeap.peek() >input[i]){
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer:maxHeap
             ) {
           result.add(integer);
        }
        return result;
    }
}
