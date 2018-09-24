package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-24 14:20
 * 题目描述
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 * 当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * <p>
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class P30_FindGreatestSumOfSubArray {
    public static void main(String[] args) {
        int[] array = {6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(FindGreatestSumOfSubArray(array));
    }

    /**
     * 求最大子序列和
     * 解题思路：
     * 1、因为要求连续字数组，所以要判断好起始位置
     * 2、如果当前的结果和加上接下来的元素还小于接下来的这个元素（当前和为负数了），则以接下来的数为起始位置
     * 3、如果接下来的元素为负数，加上他之后必然小于当前和，所以需要设置一个变量记录所有和中的最大值，最后返回这个最大值即可
     * @param array
     * @return
     */
    public static int FindGreatestSumOfSubArray(int[] array) {
        int sum = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max + array[i], array[i]);
            sum = Math.max(sum, max);
        }
        return sum;
    }
}
