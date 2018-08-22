package jiazhioffer2;

import com.sun.org.apache.bcel.internal.generic.RET;

/**
 * @Author Zhang
 * @Date 2018/8/21 9:00
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class P53_IsNumeric {
    public static void main(String[] args) {
        String string = "+12e+";

        char[] str = string.toCharArray();
        System.out.println(isNumeric1(str));//false
        System.out.println(isNumeric2(str));//false
        System.out.println(isNumeric3(str));//true{使用这个也通过了牛客网上面的用例}
    }

    /**
     * 方法一：使用内置函数
     * 方法二：正则校验
     * 方法三：制定规则进行校验
     * @param str
     * @return
     */
    public static boolean isNumeric1(char[] str){
        try {
            double re = Double.parseDouble(new String(str));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isNumeric2(char[] str){
        String string = String.valueOf(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }

    public static boolean isNumeric3(char[] str){
        //标记符号、E、小数点是否出现过
        boolean sign = false,decimal = false,hasE  =false;
        for (int i = 0; i < str.length; i++) {
            if(str[i] == 'e'|| str[i] == 'E'){
                if(i == str.length-1) return false;//e后面一定要接数字
                if (hasE) return false;//不能同时存在两个e
                hasE = true;
            }else if (str[i] == '+' ||str[i] == '-'){
                //第二次出现标记符号，则必须紧跟在e之后
                if (sign && str[i-1]!= 'e'&&str[i-1]!= 'E') return false;
                //第一次出现标记符号，且不是在字符串开头，则也必须紧接在e之后
                if (!sign&& i>0&&str[i-1]!='e' && str[i-1] != 'E') return false;
                sign = true;
            }else if (str[i] == '.'){
                //e后面不能接小数点，小数点不能出现两次
                if (hasE || decimal) return false;
                decimal = true;
            }else if (str[i] < '0' ||str[i] >'9'){
                return  false;
            }
        }
        return true;
    }
}
