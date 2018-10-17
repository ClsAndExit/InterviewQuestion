package onlineWrittenTest.bianlifeng;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Mr.Zhang
 * @create 2018-09-28 10:09
 *
 * 一个字符串，字符串中的字符只包含ASCII码之内的值，
 * 请输出字符串的所有大小写组合（若包含非字母，直接输出即可）
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        ArrayList<String> strs = solution(str);

        for (String s : strs) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> solution(String s){
        ArrayList<String> strs = new ArrayList<String>();
        char[] chars = s.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            //if ()
        }


        return strs;
    }
}
