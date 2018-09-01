package jianzhioffer2;

/**
 * @Author Zhang
 * @Date 2018/8/17 19:41
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 *      对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出  循环左移3位  后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 */
public class P43_LeftRotateString {
    public static void main(String[] args) {
        String string = "123456";
        System.out.println(LeftRotateString(string,2));
    }

    /**
     * 方法一：使用内置函数substring
     * 方法二：应用公式
     *        （1）假设字符串abcdef，n=3，设X=abc，Y=def，所以字符串可以表示成XY，
     *             如题干，问如何求得YX。假设X的翻转为XT，XT=cba，同理YT=fed，那么YX=(XTYT)T，三次翻转后可得结果。
     * @param str
     * @param n
     * @return
     */
    public static String LeftRotateString(String str,int n){
        int begin = 0;
        int end = str.length()-1;
        if(str.length() == 0 || n == 0){
            return str;
        }
        char[] chars = str.toCharArray();
        flip(chars,begin,n-1);
        flip(chars,n,end);
        flip(chars,begin,end);
        String tmpStr = new String(chars);
        return tmpStr;
    }

    public static String LeftRotateString1(String str,int n){
        int len = str.length();
        if (len == 0){
            return str;
        }
        n %= len;
        String tmp = str+str;
        return tmp.substring(n,len+n);
    }

    public static void flip(char[] array,int i,int j){
        while (i<j){
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;

            i++;
            j--;
        }
    }
}
