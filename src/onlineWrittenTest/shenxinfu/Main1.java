package onlineWrittenTest.shenxinfu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Mr.Zhang
 * @create 2018-09-21 18:57
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < t; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < 6; j++) {
                int target = scan.nextInt();
                list.add(target);
            }
            lists.add(list);
        }
        for (int i = 0; i < t; i++) {
            String s = solution(lists.get(i));
            System.out.println(s);
        }
    }

    public static String solution(ArrayList<Integer> list) {
        String result;
        Object[] vals = list.toArray();
        int[] val = new int[vals.length];
        for (int i = 0; i < vals.length; i++) {
            val[i] = (int) vals[i];
        }
        double x = 0.00;
        double y = 0.00;
        try{
        y = ((val[3] * val[2]) - (val[0] * val[5])) / ((val[1] * val[3]) - (val[4] * val[0]));
        x = ((val[2] * val[4]) - (val[5] * val[1])) / ((val[0] * val[4]) - (val[3] * val[1]));
        }catch (Exception e){
            result="UNKNOWN";
        }
        int tmpx = (int) x;
        int tmpy = (int) y;
        if (x == tmpx && y == tmpy && x> 0 && y > 0){
            result = (x+" "+y);
        }else {
            result="UNKNOWN";
        }
        return result;
    }
}
