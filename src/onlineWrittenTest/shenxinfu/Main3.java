package onlineWrittenTest.shenxinfu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Mr.Zhang
 * @create 2018-09-21 20:40
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        ArrayList<int[][]> matrixs = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int k = scan.nextInt();
            int [][] matrix = new int[n][m];
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    matrix[j][l] = scan.nextInt();
                }
            }
            matrixs.add(matrix);
        }
        for (int i = 0; i < matrixs.size(); i++) {
            System.out.println(maxVale(matrixs.get(i)));
        }
    }

    /**
     * 每一列中的最大值相加
     * 如果出现两个最大值在同一行的情况，则加上第二大的（看谁减小的小）
     * @param matrix
     * @return
     */
    public static int maxVale (int[][] matrix){
        int result = 0;
        int rows = matrix.length;
        int colm = matrix[0].length;
        int [] max = new int[colm];
        loop1:
        for (int i = 0; i < rows; i++) {
            loop2:
            for (int j = 0; j < colm; j++) {
                max[j] = Math.max(max[j],matrix[i][j]);
            }
        }
        for (int i = 0; i < colm; i++) {
            result += max[i];
        }
        return result;
    }
}
