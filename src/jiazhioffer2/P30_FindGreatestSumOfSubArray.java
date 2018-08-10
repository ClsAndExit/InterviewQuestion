package jiazhioffer2;

import java.lang.management.ManagementFactory;

public class P30_FindGreatestSumOfSubArray {
    public static void main(String[] args) {
        int[] array = {6,-3,-2,7,-15,1,2,2};
        System.out.println(FindGreatestSumOfSubArray(array));
    }

    public static int FindGreatestSumOfSubArray(int[] array){
        int sum = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max= Math.max(max+array[i],array[i]);
            sum = Math.max(sum,max);
        }
        return sum;
    }
}
