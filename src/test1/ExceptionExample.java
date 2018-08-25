package test1;

import java.util.Scanner;

/**
 * @Author Zhang
 * @Date 2018/8/25 11:20
 */
public class ExceptionExample {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int AhourSample =scn.nextInt();//每小时采样数
        //System.out.println(AhourSample);
        int hours =scn.nextInt();//共采样几小时
        //System.out.println(hours);
        int[] selectarray = new int[AhourSample*hours];
        int arraylength = selectarray.length;
        for(int i = 0;i<arraylength;i++){
            int line =scn.nextInt();
//            if(line!=0){
//                selectarray[i] = line;
//            }
//            else {
//                selectarray[i] = selectarray[i-AhourSample];
//            }
            selectarray[ i ] = line;
        }
        System.out.println(selectarray[0]);

    }
}
