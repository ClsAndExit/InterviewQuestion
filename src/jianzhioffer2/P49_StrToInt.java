package jianzhioffer2;

/**
 * @Author Zhang
 * @Date 2018/8/20 9:18
 *
 * 题目描述
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class P49_StrToInt {
    public static void main(String[] args) {
        String str = "+214748q36491";
        String str2 = "zbc";
        System.out.println(StrToInt(str));
    }

    /**
     * 输入描述:
     * 输入一个字符串,包括数字字母符号,可以为空
     * 输出描述:
     * 如果是合法的数值表达则返回该数字，否则返回0
     *
     * 方法一：利用ASCII码实现
     * @param str
     * @return
     */
    public static int StrToInt(String str){
        //怎样判断int是否溢出？？
        if(str.length() == 0 || str == null){
            return 0;
        }
        boolean isNegative = str.charAt(0) == '-';
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c= str.charAt(i);
            //符号判定
            if (i==0&&(c=='+'||c=='-')){
                continue;
            }
            //非法输入
            if (c<'0'||c>'9'){
                return 0;
            }
            ret = ret*10+(c-'0');
        }
        return isNegative ? -ret:ret;
    }
}
