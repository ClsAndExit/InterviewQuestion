package onlineWrittenTest.wangyi.myAnswer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 6 3
 * 1 3 5 2 5 4
 * 1 1 0 1 0 0
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //上课时长
        int longOFClass = sc.nextInt();
        //叫醒一次持续的时长
        int longOFActive = sc.nextInt();
        //每分钟的分值
        int[] goardOFMinute =new int[longOFClass];
        for (int i = 0; i < longOFClass; i++) {
            goardOFMinute[i] = sc.nextInt();
        }
        //每分钟是否清醒
        int[] isActive = new int[longOFClass];
        for (int i = 0; i < longOFClass; i++) {
            isActive[i] = sc.nextInt();
        }
        //由多长时间是睡着的
        int isWeek =0 ;
        for (int i = 0; i < isActive.length; i++) {
            if(isActive[i] ==0){
                isWeek++;
            }
        }
        int index= isWeek;
        //总共的分值
        int count =0;
        //每一次叫醒可以获得的分值
        int twoTime =0;
        int[] oneTime = new int[isWeek];
        int j =0;
        for (int i = 0; i < longOFClass; i++) {
            if(isActive[i] == 1){
                count+=goardOFMinute[i];
            }else{
                //这种写法只能保证不超出总的课程时长
                if ((i+longOFActive) > longOFClass){
                    longOFActive = longOFClass-i;
                }
                for (j = i; j < longOFActive+i; j++) {
                    twoTime+=goardOFMinute[j];
                }
                i=i+j-1;
                oneTime[--isWeek] = twoTime;
                twoTime =0;
            }
        }
        Arrays.sort(oneTime);
        System.out.println(count+ oneTime[index-1]);
    }
}
