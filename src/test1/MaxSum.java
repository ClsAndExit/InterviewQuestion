package test1;

import java.util.ArrayList;
import java.util.Stack;

public class MaxSum {
    public static void main(String[] args) {
        int [] array = {5,1,3,4,9,7,6,8};

        //最大升序序列：1，3，4，7，8
    }

    /**
     * @param array
     * @return
     */
    public static int getMax (int[] array){
        int result = Integer.MIN_VALUE;
        int length = array.length;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int maxOfList = Integer.MIN_VALUE;
        int minOfList = Integer.MAX_VALUE;
        for (int i = length-1; i >= 0 ; i--) {
            minOfList = Math.min(minOfList,array[i]);
            maxOfList = Math.max(maxOfList,array[i]);

            if(i == length-1){
                arrayList.add(array[i]);
            }else{
                if (array[i] == minOfList ){
                    arrayList.add(array[i]);
                }else if (array[i] == maxOfList){
                    if (array[i] >= sumOfArray(arrayList)){
                        arrayList.clear();
                        arrayList.add(array[i]);
                    }
                }else{

                }
            }
        }
        return result;
    }

    //

    //数组中的最大值
    public static int sumOfArray(ArrayList<Integer> array){
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < array.size() ; i++) {
            sum += array.get(i);
        }
        return sum;
    }

}
