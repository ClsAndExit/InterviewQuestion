package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-01 15:14
 *
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class P1_FindInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {12,13,14,15,16},
                {23,24,25,26,27},
                {34,35,36,37,38},
                {45,46,47,48,49},
                {51,52,53,54,55}
        };
        int n = 53;

        boolean find = find(matrix,n);
        System.out.println(find);
    }
    public static boolean find(int [][] matrix,int num){
        boolean flag = false;
        //从矩阵的左上角开始遍历
        int row = matrix.length-1;
        int col = matrix[0].length-1;

        //定义下标i（行）,j（列）
        int i = 0,j=col;

        //下标一直保持在矩阵内
        while (i<=row && j>=0){
            if (matrix[i][j] == num){
                flag = true;
                break;
            }else if(matrix[i][j] > num){
                //如果待查找的值小于当前矩阵位置的值，则应该使矩阵的值网小变化，则根据题意应该是将列数减小
                j--;
            }else {
                i++;
            }
        }
        return flag;
    }
}
