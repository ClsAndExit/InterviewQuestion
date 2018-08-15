package searching;

/**
 * @Author Zhang
 * @Date 2018/8/15 8:59
 * 斐波那契查找;
 *  斐波那契查找就是在二分查找的基础上根据斐波那契数列进行分割的
 *  基本思想：
 *      在斐波那契数列找一个等于略大于查找表中元素个数的数F[n]，将原查找表扩展为长度为F[n](如果要补充元素，则补充重复最后一个元素，
 *  直到满足F[n]个元素)，完成后进行斐波那契分割，即F[n]个元素分割为前半部分F[n-1]个元素，后半部分F[n-2]个元素，找出要查找的元素在那一部分并递归，直到找到。
 *
 *      斐波那契查找的时间复杂度还是O(log 2 n )，但是 与折半查找相比，斐波那契查找的优点是它只涉及加法和减法运算，而不用除法，
 *  而除法比加减法要占用更多的时间，因此，斐波那契查找的运行时间理论上比折半查找小，但是还是得视具体情况而定。
 *
 *      当有序表的元素个数不是斐波那契数列中的某个数字时，需要把有序表的元素个数长度补齐，让它成为斐波那契数列中的一个数值
 */
public class FibonacciSearch {
    public static final int MAXSIZE = 20;
    public static void main(String[] args) {
        int[] f = fibonacci();
        for (int i : f) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] data = { 1, 5, 15, 22, 25, 31, 39, 42, 47, 49, 59, 68, 88 };

        int search = 39;
        int position = fibonacciSearch(data, search);
        System.out.println("值" + search + "的元素位置为：" + position);
    }

    //构建斐波那契数列
    public static int[] fibonacci(){
        int[] f= new int[MAXSIZE];
        f[0] =0;
        f[1] =1;
        for (int i = 2; i <MAXSIZE ; i++) {
            f[i] += f[i-1]+f[i-2];
        }
        return f;
    }

    //斐波那契查找
    public static  int  fibonacciSearch(int[]data,int key){
        int low = 0;
        int high = data.length - 1;
        int mid = 0;

        // 斐波那契分割数值下标
        int k = 0;

        // 序列元素个数
        int i = 0;

        // 获取斐波那契数列
        int[] f = fibonacci();

        // 获取斐波那契分割数值下标
        while (data.length > f[k] - 1) {
            k++;
        }

        // 创建临时数组
        int[] temp = new int[f[k] - 1];
        for (int j = 0; j < data.length;j++) {
            temp[j] = data[j];
        }

        // 序列补充至f[k]个元素
        // 补充的元素值为最后一个元素的值
        for (i = data.length; i < f[k] - 1; i++) {
            temp[i] = temp[high];
        }

        for (int j : temp) {
            System.out.print(j + " ");
        }
        System.out.println();

        while (low <= high) {
            // low：起始位置
            // 前半部分有f[k-1]个元素，由于下标从0开始
            // 则-1 获取 黄金分割位置元素的下标
            mid = low + f[k - 1] - 1;

            if (temp[mid] > key) {
                // 查找前半部分，高位指针移动
                high = mid - 1;
                // （全部元素） = （前半部分）+（后半部分）
                // f[k] = f[k-1] + f[k-1]
                // 因为前半部分有f[k-1]个元素，所以 k = k-1
                k = k - 1;
            } else if (temp[mid] < key) {
                // 查找后半部分，高位指针移动
                low = mid + 1;
                // （全部元素） = （前半部分）+（后半部分）
                // f[k] = f[k-1] + f[k-1]
                // 因为后半部分有f[k-1]个元素，所以 k = k-2
                k = k - 2;
            } else {
                // 如果为真则找到相应的位置
                if (mid <= high) {
                    return mid;
                } else {
                    // 出现这种情况是查找到补充的元素
                    // 而补充的元素与high位置的元素一样
                    return high;
                }
            }
        }
        return -1;
    }
}
