package onlineWrittenTest.zhaoshang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mr.Zhang
 * @create 2018-09-16 19:36
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1= scan.nextLine();
        String s2 = scan.nextLine();
        String[] s1s = s1.split(" ");
        String[] s2s = s2.split(" ");

        System.out.println(solution(s1s,s2s));
    }

    public static int solution(String[] s1,String[] s2){
        int [] a1 = new int[s1.length];
        int [] a2 = new int[s2.length];

        for (int i = 0; i < s1.length; i++) {
            a1[i] = Integer.valueOf(s1[i]);
        }

        for (int i = 0; i < s2.length; i++) {
            a2[i] = Integer.valueOf(s2[i]);
        }

        Arrays.sort(a1);
        Arrays.sort(a2);

        int result = 0;
        int index = 0;
        for (int i = 0; i < a2.length; i++) {
            if(a2[i] >= a1[index]){
                result ++;
                index++;
            }
            if(index == a1.length){
                break;
            }
        }

        return result;
    }
}
