package onlineWrittenTest.shenxinfu;

import java.util.Scanner;

/**
 * @author Mr.Zhang
 * @create 2018-09-21 20:35
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int[] array = new int[t];
        for (int i = 0; i < t; i++) {
            array[i] = scan.nextInt();
        }

        System.out.println(FindGreatestSumOfSubArray(array));

    }
    public static int FindGreatestSumOfSubArray(int[] array){
        int sum = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max= Math.min(max+array[i],array[i]);
            sum = Math.min(sum,max);
        }
        return sum;
    }
}
