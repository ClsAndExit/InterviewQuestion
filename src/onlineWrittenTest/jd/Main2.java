package onlineWrittenTest.jd;

import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[n][3];
        for (int i = 0; i < n; i++) {
            array[i][0] = scanner.nextInt();
            array[i][1] = scanner.nextInt();
            array[i][2] = scanner.nextInt();
        }

        System.out.println(countOF(array));
        //System.out.println(1);
    }

    /**
     * 返回不合格产品的个数
     *
     * @param array
     * @return
     */
    public static int countOF(int[][] array) {
        if (array.length <=0 )
            return 0;
        int row = array.length;
        int countNum = 0;
        loop1:
        for (int i = 0; i < row; i++) {
            loop2:
            for (int j = i; j < row; j++) {
                if (j != i && allSmall(array[i], array[j])) {
                    countNum += 1;
                    break loop2;
                }
            }
        }

        /**
         * 2 3 4
         * 1 1 1
         * 1 1 1
         */
        return countNum;
    }

    /**
     * 判断任意两个产品其中一个是否所有指标都小于另一个，
     * 如果是则说明它是不合格的
     *
     * @param array1
     * @param array2
     * @return
     */
    public static boolean allSmall(int[] array1, int[] array2) {
        if (array1.length != array2.length)
            return false;
        int [] flag = new int[3];
        int length = array1.length;
        for (int i = 0; i < length; i++) {
            if (array1[i] < array2[i]) {
                flag[i] = 1;
            } else if (array1[i] > array2[i])  {
                flag[i] = 0;
            }else if (array1[i] == array2[i]) {
                flag[i] = (int)(Math.random()*100);
            }
        }
        return flag[0]==flag[1] && flag[1]==flag[2];
    }
}
