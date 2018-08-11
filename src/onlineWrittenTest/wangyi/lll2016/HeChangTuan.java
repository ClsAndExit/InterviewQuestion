package onlineWrittenTest.wangyi.lll2016;

import java.util.Scanner;

/**
 * 递归
 * 动归
 */
public class HeChangTuan {
    public static void main(String[] args) {

        Scanner scan  = new Scanner(System.in);
        //输入初始化
        //总人数
        int n = scan.nextInt();
        int[] students = new int[n];
        for (int i = 0; i < n; i++) {
            //能力值
            students[i] = scan.nextInt();
        }

        //中选取学生数量
        int k = scan.nextInt();
        //编号最大差值（数组下标最大差值）
        int d = scan.nextInt();

        //初始化辅助变量
        int result = 0;//用来存储最终结果


    }
}
