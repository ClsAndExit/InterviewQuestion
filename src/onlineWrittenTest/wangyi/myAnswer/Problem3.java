package onlineWrittenTest.wangyi.myAnswer;

import java.util.Scanner;

/**
 * 输出字符串的全排列
 */
public class Problem3 {
    public static void main(String[] args) {
        //全排列问题
        Scanner scan = new Scanner(System.in);
        //a的个数
        int n = scan.nextInt();
        //Z的个数
        int m = scan.nextInt();
        //要查找第几个单词
        int x = scan.nextInt();

        char[] numa = new char[n];
        char[] numz = new char[m];
        for (int i = 0; i < n; i++) {
            numa[i] = 'a';
        }
        for (int i = 0; i < m; i++) {
            numz[i] = 'z';
        }

    }
}
