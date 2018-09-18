package onlineWrittenTest.zhaoshang;

import java.util.Scanner;

/**
 * @author Mr.Zhang
 * @create 2018-09-16 19:50
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int target = scan.nextInt();
        System.out.println(Jump(target));
    }

    public static int Jump(int target){
        if(target == 1){
            return  1;
        }
        if (target == 2){
            return 2;
        }
        int first = 1;
        int second = 2;
        int result = 0;
        while (target>2){
            result = first+second;
            first = second;
            second = result;
            target --;
        }
        return result;
    }
}
