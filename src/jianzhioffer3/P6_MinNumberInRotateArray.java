package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-01 21:53
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class P6_MinNumberInRotateArray {
    public static void main(String[] args) {
        int[] array = {3,4,5,1,2};
        System.out.println(minNumberInRotateArray(array));
    }

    /**
     * 方法一：直接遍历数组，找到array[i]<array[i-1]，则array[i]即为所求
     * 方法二：二分查找变形
     *      (1)mid = low + (high-low)/2
     *      分三种情况：
     *      (2)如果array[mid] > array[high]:则最小的值一定在数组的后半部分；low = mid +1
     *      (3)如果array[mid] = array[high]:这种情况可能是数组中存在相同的值，不好判断只好一个一个试：high = high-1
     *      (4)如果array[mid] < array[high]:最小值一定在数组的左边或是mid本身：high= mid
     * @param array
     * @return
     */
    public static int minNumberInRotateArray(int[] array){
        int low = 0;
        int high = array.length-1;
        //当low = high 则返回该值即为所求
        while (low<high){
            int mid = low+(high-low)/2;
            if (array[mid] > array[high]){
                low = mid+1;
            }else if (array[mid] == array[high]){
                high --;
            }else {
                high = mid;
            }
        }
        return array[low];
    }
}
