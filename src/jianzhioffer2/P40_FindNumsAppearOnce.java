package jianzhioffer2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Zhang
 * @Date 2018/8/17 15:01
 *
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字.
 */
public class P40_FindNumsAppearOnce {
    public static void main(String[] args) {
        int[] array = {1,1,2,2,3,3,4,4,5,5,6,7};
        int[] num1= new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce2(array,num1,num2);
        System.out.println(num1[0]+"--------"+num2[0]);
    }

    /**
     * 方法一：哈希表
     * 方法二：异或运算
     *        （1）首先需要将数组中所有元素进行异或，得到的结果为这两个只出现奇数次的数字相异或的结果
     *        （2）通过异或的性质可知，结果中的每一个1都的代表这两个数字的二进制表示中该位上的0或1不同
     *        （3）通过该性质将原数组分成两组，一组在那一位上的标识与其中一个数的标识相同，另一组反之
     *        （4）然后同第一步相同，分别对每一组中的内容进行异或，最终即可得到结果
     *        （相同的数肯定被分到了同一组，那两个数字肯定分到不同组）
     * @param array
     * @param num1
     * @param num2
     */

    public static void FindNumsAppearOnce2(int[]array,int[] num1,int[] num2){
        if(array.length == 2){
            num1[0] = array[0];
            num2 [0] = array[1];
        }
        int binaryStr = 0;
        for (int i = 0; i < array.length; i++) {
            binaryStr ^= array[i];
        }
        int index = firstOf1(binaryStr);
        for (int i = 0; i < array.length; i++) {
            if (isBit1Ofindex(array[i],index)){
                num1[0] ^= array[i];
            }else {
                num2[0] ^= array[i];
            }
        }
    }

    public static boolean isBit1Ofindex(int num,int index){
        return ((num >> index) & 1 )==1;
    }
    public static int firstOf1(int num){
        int index =0;
        while ((num & 1)==0 && index<32){
            num >>= 1;
        }
        return index;
    }
    public static void FindNumsAppearOnce1(int[]array,int[] num1,int[] num2){
        HashMap<Integer,Integer> numberOfVal = new HashMap<Integer, Integer>();
        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i < array.length; i++) {
            if (numberOfVal.containsKey(array[i])){
                int value = numberOfVal.get(array[i]);
                numberOfVal.put(array[i],value+1);
            }else{
                numberOfVal.put(array[i],1);
            }
        }
        for (Map.Entry e:numberOfVal.entrySet()) {
            if ((int)e.getValue() % 2 == 0){
                continue;
            }else {
                arrayList.add((int)e.getKey());
            }
        }
        num1[0] = arrayList.get(0);
        num2[0] = arrayList.get(1);
    }
}
