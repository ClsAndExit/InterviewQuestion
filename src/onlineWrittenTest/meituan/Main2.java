package onlineWrittenTest.meituan;

import java.util.Scanner;
//82%
/**
 * @author Mr.Zhang
 * @create 2018-09-06 20:17
 * 小明拿到了一个数列a1 , a2 , ... an ，小明想知道存在多少个区间[l,r]同时满足下列两个条件：
 * <p>
 * 1、r-l+1=k;
 * <p>
 * 2、在a l , a l+1,...ar中，存在一个数至少出现了 t 次。
 * <p>
 * 输出满足条件的区间个数
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int t = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int count = count(array, k, t);
        System.out.println(count);
    }

    /**
     * 统计出在数组的一部分中每个元素出现了多少次
     *
     * @param array
     * @param begin
     * @param end
     * @return
     */
    public static int[] arrayTime(int[] array, int begin, int end) {
        int[] arrayTime = new int[end - begin + 1];
        for (int i = begin; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (array[j] == array[i]) {
                    if (arrayTime[i - begin] == 0)
                        arrayTime[i - begin] = 1;
                    else
                        arrayTime[i - begin]++;
                }
            }
        }
        return arrayTime;
    }

    /**
     * K为窗口的长度
     *
     * @param array
     * @param k
     * @param t
     * @return
     */
    public static int count(int[] array, int k, int t) {
        int count = 0;
        int len = k;//记录窗口的长度
        int time = t;//记录数出现的次数
        loop1:
        for (int i = 0; i < array.length - k+1; i++) {
                int [] arrTim = arrayTime(array,i,i+len-1);
               loop2:
               for (int l = 0; l < arrTim.length; l++) {
                    if (arrTim[l] >= time-1){
                        count++;
                        break loop2;
                    }
                }
            }
        return count;
    }
}
