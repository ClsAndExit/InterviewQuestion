package jianzhioffer2;

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
        //有效性检验，str到尾部，pattern到尾部，匹配成功
        if (strIndex== str.length && patternIndex ==pattern.length){
            return true;
        }
        //pattern先到尾部，匹配失败
        if (strIndex != str.length && patternIndex ==pattern.length){
            return false;
        }

        //模式第二个是*，且字符串第一个和模式第一个匹配，分三种匹配模式
        //如果不匹配，模式后移两位（可以出现0次）

        //下一个是*
        if (patternIndex+1<pattern.length && pattern[patternIndex+1] == '*'){
            //当前字符匹配，且str未到达尾部
            if ((strIndex!=str.length&&pattern[patternIndex] == str[strIndex])||
                    (pattern[patternIndex] == '.' && strIndex != str.length)){
                /**
                 * 三种情况：
                 * 1、模式后移2，视为匹配0个字符
                 * 2、模式后移2，字符串后移1，视为匹配1个字符
                 * 3、模式Index不变，字符串后移一位，去匹配字符串中的下一个字符
                 */
                return matchCore(str,strIndex,pattern,patternIndex+2)
                        ||matchCore(str,strIndex+1,pattern,patternIndex+2)
                        ||matchCore(str,strIndex+1,pattern,patternIndex);
            }else {
                return matchCore(str,strIndex,pattern,patternIndex+2);
            }
        }
        //模式第二个不是*，且字符串第一个和模式第一个匹配，则都后移一位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])||
                (pattern[patternIndex] == '.' && strIndex != str.length)){
            return matchCore(str,strIndex+1,pattern,patternIndex+1);
        }

        return false;
    }
}



















