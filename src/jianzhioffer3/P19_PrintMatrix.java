package jianzhioffer3;

import java.util.ArrayList;

/**
 * @author Mr.Zhang
 * @create 2018-09-08 19:05
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1  2  3  4
 * 5  6  7  8
 * 9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class P19_PrintMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7},
        };

        ArrayList<Integer> list = print(matrix);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * 模拟上下左右的移动过程
     *
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> print(int[][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int r = matrix.length;
        int c = matrix[0].length;
        int total = r * c;
        int right_r = r;
        int right_c = c;
        int left_r = 0, left_c = 0;
        int i = 0, j = 0;

        while(total > 0) {
            //从左到右打印
            while(total>0&&j<right_c) {
                total--;
                arrayList.add(matrix[i][j]);
                j++;
            }
            j--;
            i++;
            //从上到下打印(最后一行没有动，留待从右到左的时候再动)
            while (total>0&&i<right_r-1) {
                total --;
                arrayList.add(matrix[i][j]);
                i++;
            }

            //从右到左打印
            while (total>0&&j>=left_c) {
                total--;
                arrayList.add(matrix[i][j]);
                j--;
            }
            j++;
            i--;

            //从下到上打印
            while (total>0&&i>left_r) {
                total--;
                arrayList.add(matrix[i][j]);
                i--;
            }
            i++;
            j++;
            left_c++;
            left_r++;
            right_c--;
            right_r--;
        }
        return arrayList;
    }
}
