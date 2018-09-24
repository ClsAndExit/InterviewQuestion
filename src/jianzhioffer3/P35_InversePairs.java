package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-24 19:49
 */
public class P35_InversePairs {
    public static void main(String[] args) {
        int[] array = {2, 3, 34, 4, 5, 6, 7, 8};
        System.out.println(InversePairs(array));
    }

    /**
     * 解题思路;
     * 1、嵌套循环
     * 2、归并思想
     *
     * @param array
     * @return
     */
    public static int InversePairs(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        int count = InversePariseCore(array, copy, 0, array.length - 1);
        return count % 1000000007;
    }

    public static int InversePariseCore(int[] array, int[] copy, int low, int high) {
        if (low == high) {
            return 0;
        }
        int mid = (low + high) >> 1;
        int leftCount = InversePariseCore(array, copy, low, mid) % 1000000007;
        int rightCount = InversePariseCore(array, copy, mid + 1, high) % 1000000007;
        int count = 0;
        int i = mid;
        int j = high;
        int locCopy = high;
        while (i >= low && j > mid) {
            if (array[i] > array[j]) {
                count += j - mid;
                copy[locCopy--] = array[i--];
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
            } else {
                copy[locCopy--] = array[j--];
            }
        }
        for (; i >= low; i--) {
            copy[locCopy--] = array[i];
        }
        for (; j > mid; j--) {
            copy[locCopy--] = array[j];
        }
        for (int s = low; s <= high; s++) {
            array[s] = copy[s];
        }
        return (leftCount + rightCount + count) % 1000000007;
    }
}
