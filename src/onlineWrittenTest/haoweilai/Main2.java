package onlineWrittenTest.haoweilai;

import java.util.ArrayList;

/**
 * @author Mr.Zhang
 * @create 2018-09-01 10:28
 * 2.根据x + y = x|y，给定x, 求满足要求的第 k 个 y
 * 解析：位或（｜）表示相对应的每位至少有一个为1，则结果为1，只有两个都为0，结果才为0.
 *      5 的二进制 101;8 的二进制 1000;
 *      5+8 = 13  13的二进制1101
 */
public class Main2 {
    public static void main(String[] args) {
        int x = 10;
        int k = 1;
        int y = GetYOrderK1(x,k);
        System.out.println(y);
    }

    /**
     * 枚举法
     * @param x
     * @param k
     * @return
     */
    public static int GetYOrderK1(int x,int k){
        return 0;
    }


        /**
         * 位运算的方法放弃
         * @param x
         * @param k
         * @return
         */
    public static int GetYOrderK(int x,int k){
        int result = 0;
        String binaryString = Integer.toBinaryString(x);
        int length = binaryString.length();
        //记录下在二进制中哪些位数是0
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            if (binaryString.charAt(i) == '0'){
                //注意高低位变化
                arrayList.add(length-i-1);
            }
        }

        return result;
    }
}
