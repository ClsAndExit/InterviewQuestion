package sorting;

import java.util.Arrays;

/**
 * @Author Zhang
 * @Date 2018/8/13 15:08
 */
public class RadixSort {
    public static void main(String[] args) {
        int [] array = new int[] { 1100, 192, 221, 12, 23 };

        //10表示基数的个数（0~9），4表示数组中元素的最大位数（个十百千。。。）
        radixSort(array,10,4);

        System.out.println(Arrays.toString(array));
    }

    public static void radixSort(int[] array,int radix,int d){
        //缓存数组
        int [] tmp = new int[array.length];
        //buckets数组用于记录待排序元素的信息
        //buckets数组定义了max-min个桶
        int [] buckets = new int[radix];

        for (int i = 0,rate =1; i <d ; i++) {
            //重置count数组，开始统计下一个关键字
            Arrays.fill(buckets,0);
            //将data数组中的元素完全复制到tmp数组中
            System.arraycopy(array,0,tmp,0,array.length);

            //计算每个待排序数据的关键字
            for (int j = 0; j < array.length; j++) {
                int subkey = (tmp[j]/rate)%radix;
                buckets[subkey]++;
            }

            for (int j = 1 ; j < radix ; j++) {
                buckets[j] = buckets[j] + buckets[j-1];
            }

            //按子关键字对指定的数据进行排序
            for (int m = array.length-1; m >=0 ; m--) {
                int subkey = (tmp[m]/rate)%radix;
                array[--buckets[subkey]] = tmp[m];
            }
            rate*=radix;
        }
    }
}
