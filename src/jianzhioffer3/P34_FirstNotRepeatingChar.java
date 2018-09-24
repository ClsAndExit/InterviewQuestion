package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-24 19:35
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class P34_FirstNotRepeatingChar {
    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("google"));
    }

    /**
     * 解题思路：
     * 1、嵌套循环
     * 2、哈希
     * 3、计数排序
     * @param str
     * @return
     */
    public static int FirstNotRepeatingChar(String str){
        if (str == null || str.length() < 0){
            return -1;
        }
        char[] chars = str.toCharArray();
        int[] tong = new int[(int)'z' +1];
        for (int i = 0; i < chars.length; i++) {
            tong[(int)chars[i]]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (tong[(int) chars[i]] == 1){
                return i;
            }
        }
        return -1;
    }
}
