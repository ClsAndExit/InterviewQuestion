package test1;

import java.util.Scanner;

/**
 * @author Mr.Zhang
 * @create 2018-09-01 20:53
 */
public class TestUtil {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String[] strings = new String[4];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = scanner.nextLine();
        }
        String str = getDatingTime(strings);
    }

    public static String getDatingTime(String[] data) throws Exception {
        // 请在此添加代码
        String str1 = data[0];
        int length = str1.length();
        String str2 = data[1];

        int index1 = 0;
        int index2 = 0;
        //找到第一个表示
        char first = ' ';
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) >= 'A' || str1.charAt(i) <= 'Z') {
                for (int j = 0; j < str2.length(); j++) {
                    if (str1.charAt(i) == str2.charAt(j)) {
                        first = str2.charAt(j);
                        index1 = i;
                        index2 = j;
                        break;
                    }
                }
            }
        }
        //寻找第二个标识
        char second = ' ';
        for (int i = index1 + 1; i < length; i++) {
            if (str1.charAt(i) >= 'A' || str1.charAt(i) <= 'Z') {
                for (int j = index2 + 1; j < str2.length(); j++) {
                    if (str1.charAt(i) == str2.charAt(j)) {
                        second = str2.charAt(j);
                    }
                }
            }
        }
        //寻找第三个标识
        String str3 = data[2];
        String str4 = data[3];
        int l3 = str3.length();
        int l4 = str4.length();
        int minL = Math.min(l3, l4);
        int flag3 = 0;
        for (int i = 0; i < minL; i++) {
            if (str3.charAt(i) == str4.charAt(i)) {
                flag3 = i;
            }
        }
        String fl1 = change1(first);
        String f2 = change2(second);
        String result = fl1 + " " + f2 + ":" + flag3;
        return result;
    }


    public static String change2(char second) {
        int date = 0;
        if (second >= '0' && date <= '9') {
            return Character.toString(second);
        } else
            date = (int) second - 55;
        return Integer.toString(date);
    }

    public static String change1(char first) {
        String result = "";
        switch (first) {
            case 'A':
                result = "MON";
                break;
            case 'B':
                result = "TUE";
                break;
            case 'C':
                result = "WED";
                break;
            case 'D':
                result = "THU";
                break;
            case 'E':
                result = "FRI";
                break;
            case 'F':
                result = "SAT";
                break;
            case 'G':
                result = "SUN";
                break;
            default:
                break;
        }
        return result;
    }

}
