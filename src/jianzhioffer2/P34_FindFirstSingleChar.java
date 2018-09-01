package jianzhioffer2;

/**
 * @Author Zhang
 * @Date 2018/8/16 14:33
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 *      并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class P34_FindFirstSingleChar {
    public static void main(String[] args) {
        String string = "ababsbdbbdbcbhjfhjwlehjq";

        char find = string.charAt(findFirstSingleChar(string));
        System.out.println(find);
    }

    /**
     * 方法一：最复杂方法O(n^2):双重循环比较字符是否出现，如果没有出现则返回下标
     * 方法二：使用map实现
     * 方法三：类似于桶排序
     * @param string
     * @return
     */
    public static int findFirstSingleChar(String string){
        /**
         * 链接：https://www.nowcoder.com/questionTerminal/1c82e8cf713b4bbeb2a5b31cf5b0417c
         * 来源：牛客网
         *
         * map<char, int> mp;
         *         for(int i = 0; i < str.size(); ++i)
         *             mp[str[i]]++;
         *         for(int i = 0; i < str.size(); ++i){
         *             if(mp[str[i]]==1)
         *                 return i;
         *         }
         *         return -1;
         */
        char [] chars = string.toCharArray();
        int [] tong = new int[(int)'z'];
        for (int i = 0; i < chars.length; i++) {
            tong[(int)chars[i]]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (tong[(int)chars[i]]==1){
                return i;
            }
        }
        return -1;
    }
}
