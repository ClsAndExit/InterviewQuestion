package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-25 12:20
 */
public class P40_FindNumsAppearOnce {
    public static void main(String[] args) {
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);

        int[] array1 = {1, 2, 1, 2, 1, 2, 3};
        System.out.println(FindNumsAppearOnce2(array1));
    }

    /**
     * 有两个数出现1次
     *
     * @param array
     * @param num1
     * @param num2
     */
    public static void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        int sum = array[0];

        for (int i = 1; i < array.length; i++) {
            sum ^= array[i];
        }
        int index = 0;//sum中第一个1出现的位置
        for (index = 0; index < 32; index++) {
            if ((sum & (1 << index)) != 0) {
                break;
            }
        }
        int sum1 = sum;
        int sum2 = sum;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & (1 << index)) != 0)
                sum1 ^= array[i];
            else
                sum2 ^= array[i];
        }
        num1[0] = sum1;
        num2[0] = sum2;
    }

    /**
     * 有1个数出现一次，其余出现两次，找出这个数
     *
     * @param array
     */
    public static int FindNumsAppearOnce1(int[] array) {
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            res = res ^ array[i];
        }
        return res;
    }

    /**
     * 数组中只有一个数出现1次，其余数字出现3次，找出这个数字
     *
     * @param a
     * @return
     */
    public static int FindNumsAppearOnce2(int[] a) {
        int[] bits = new int[32];
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 32; j++) {
                bits[j] = bits[j] + ((a[i] >> j) & 1);
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] % 3 != 0) {
                res = res | (1 << i);
            }
        }
        return res;
    }
}
