package jiazhioffer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Zhang
 * @Date 2018/8/16 9:08
 */
public class P32_PrintMinNumber {
    public static void main(String[] args) {
        //正整数数组
        int [] array = {3,32,321};
        System.out.println(printMinNumber(array));
    }

    /**
     * 方法一：全排列取最小值然后返回字符串
     * 方法二：假设我们要将几个十以内的数字排列成最小的数，那么一定是将这些数按照从小到大的顺序排列
     *          在本问题中，我们也使用相似的原理，将这些子串按照从小到大的顺序排列，然后拼接到一起就可以了
     *          但是我们在比较大小的时候需要制定新的规则
     *          例如：3<12 但是312>123 那么我们则定义为3>12
     * @param numbers
     * @return
     */
    public static String printMinNumber(int[] numbers){
        if (numbers == null|| numbers.length<=0){
            return "";
        }
        int length = numbers.length;
        String [] strs = new String[length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s1.compareTo(s2);
            }
        });
        for (int i = 0; i < length ;i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
