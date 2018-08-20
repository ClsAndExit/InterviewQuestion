package jiazhioffer2;

/**
 * @Author Zhang
 * @Date 2018/8/20 14:17
 *
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class P52_Match {
    public static void main(String[] args) {
        String str = "aaa";
        char[] strs = str.toCharArray();

        String pattern1 = "a.a";//true
        char[] pattern1s = pattern1.toCharArray();
        System.out.println(match(strs, pattern1s));

        String pattern2 = "ab*ac*a";//true
        char[] pattern2s = pattern2.toCharArray();
        System.out.println(match(strs, pattern2s));

        String pattern3 = "aa.a";//false
        char[] pattern3s = pattern3.toCharArray();
        System.out.println(match(strs, pattern3s));

        String pattern4 = "ab*a";//false
        char[] pattern4s = pattern4.toCharArray();
        System.out.println(match(strs, pattern4s));

    }

    public static boolean match(char[] str, char[] pattern) {
        if (str == null||pattern==null)
            return false;
        int strIndex = 0;
        int patternIndex =0;
        return matchCore(str,strIndex,pattern,patternIndex);
    }

    public static boolean matchCore(char[] str,int strIndex, char[] pattern,int patternIndex) {
        return false;
    }
}