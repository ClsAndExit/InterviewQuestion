package jiazhioffer2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.reflect.Array.getLength;

/**
 * @Author Zhang
 * @Date 2018/8/16 15:47
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 输入描述：
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 	对于%50的数据,size<=10^4
 * 	对于%75的数据,size<=10^5
 * 	对于%100的数据,size<=2*10^5
 *
 * 	示例1
 * 输入
 * 1,2,3,4,5,6,7,0
 * 输出
 * 7
 *
 */
public class P35_InversePairs {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(array));
    }

    /**
     * 方法一：时间复杂度o(n^2) 嵌套循环，拿当前值与数组中在它后面的所有值进行比较，
     *          如果大于后面的值，则为一个逆序对
     * 方法二：作者：海晨威
     * 链接：https://www.nowcoder.com/questionTerminal/96bd6684e04a44eb80e6a68efc0ec6c5?toCommentId=1138059
     * 来源：牛客网
     *
     * 输入数组：data=[3,2,1,5,4,6,0,7]
     *
     * 排序好数组：dataSorted=[0,1,2,3,4,5,6,7]
     *
     * 顺序遍历dataSorted数组，第一个元素0是最小的元素，因此在data数组中，0前面有多少个数，就有多少个逆序对。在0检测完之后，将0从data数组中删除，data=[3,2,1,5,4,6,7]，dataSorted数组遍历到1，而1其实就是[1,2,3,4,5,6,7]中的最小元素
     *
     * 因此，原问题就变为子问题：
     *
     * 输入数组：data=[3,2,1,5,4,6,7]
     *
     * 排序好数组：dataSorted=[1,2,3,4,5,6,7]
     *
     * ……
     *
     * 直到遍历到最后一个元素。
     * @param array
     * @return
     */
    public static int InversePairs(int[] array){
        int count = 0;
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        Arrays.sort(copy);
        for (int i = 0; i < array.length; i++) {
            int num = INdexOf(array,copy[i]);
            count+=num;
            array = remove(array,num);
        }
        return  count%1000000007;
    }

    private static int[] remove(int [] array, int index) {
        //int length = getLength(array);
        int length = array.length;
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + length);
        }
        int[] result = (int[])Array.newInstance(array.getClass().getComponentType(), length - 1);
        System.arraycopy(array, 0, result, 0, index);
        if (index < length - 1) {
            System.arraycopy(array, index + 1, result, index, length - index - 1);
        }

        return result;
    }

    public static int INdexOf(int[] array,int value){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value){
                return i;
            }
        }
        return -1;
    }
}
