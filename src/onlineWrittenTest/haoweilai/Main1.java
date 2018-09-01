package onlineWrittenTest.haoweilai;

import java.util.Scanner;

/**
 * @author Mr.Zhang
 * @create 2018-09-01 10:28
 * 1.一个数分成几份，可以被 3 整除的最大份数。比如 12345 分成12 3 45 结果为3.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //String n = scan.nextLine();
        String n = "12145";
        int m = 0;
        //字符组合
        String string = "";
        //余数分别为1和2的情况
        int c1 = 0, c2 = 0;
        int length = n.length();
        for (int i = 0; i < length; i++) {
            if ((int) n.charAt(i) % 3 == 0) {
                m += 1;
                string = "";
                c1 = 0;
                c2 = 0;
                continue;
            }
            string += n.charAt(i);
            if ((int) n.charAt(i) % 3 == 1) {
                c1 += 1;
            } else {
                c2 += 1;
            }
            if ((string != "" && (Integer.valueOf(string)% 3 == 0)) || (c1 > 0 && c2 > 0)){
                m+=1;
                string = "";
            }
            c1 = 0;
            c2 = 0;
        }
        System.out.println(m);
    }
}
