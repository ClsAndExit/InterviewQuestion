package jianzhioffer2;

/**
 * @Author Zhang
 * @Date 2018/8/25 15:42
 * 题目描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子
 * 。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如        a b c e
 *             s f c s
 *             a d e e
 * 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 */
public class P65_HasPath {
    public static void main(String[] args) {
        char[] matrix = { 'a','b','c','e','s','f','c','s','a','d','e','e' };
        int rows = 3;
        int clos = 4;
        char [] str1 = "bcced".toCharArray();//true
        char [] str2 = "abcb".toCharArray();//false
        System.out.println(new P65_HasPath().hasPath(matrix,rows,clos,str1));
        System.out.println(new P65_HasPath().hasPath1(matrix,rows,clos,str2));
    }


    private final static int[][] next = {{0,-1},{0,1},{-1,0},{1,0}};
    private int rows;
    private int clos;


    /**
     *垃圾，剑指Offer书上面的代码，居然是错的
     * @param array
     * @param rows
     * @param clos
     * @param str
     * @return
     */
    public boolean hasPath1(char[] array,int rows,int clos,char[] str){
        if (rows == 0 || clos == 0){
            return false;
        }
        this.rows = rows;
        this.clos = clos;
        boolean [][] marked = new boolean[rows][clos];
        char[][]matrix = buildMatrix(array);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < clos; j++) {
                if (backtracking(matrix,str,marked,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param matrix
     * @param str
     * @param marked
     * @param pathLen
     * @param r
     * @param c
     * @return
     */
    private boolean backtracking(char[][] matrix,char[] str,boolean[][]marked,
                                 int pathLen,int r,int c){
        if (pathLen == str.length){
            return true;
        }
        if (r<0 || r>=rows ||c<0||c>=clos || matrix[r][c] != str[pathLen] || marked[r][c]){
            return false;
        }
        for (int[] n: next) {
            if (backtracking(matrix,str,marked,pathLen+1,r+n[0],c+n[1])){
                return true;
            }
        }
        marked[r][c] = false;
        return false;
    }

    /**
     * 将数组array转化为二维数组（矩阵）
     * @param array
     * @return
     */
    private char[][] buildMatrix(char[] array){
        char[][] matrix = new char[rows][clos];
        for (int i = 0,idx = 0; i < rows; i++) {
            for (int j = 0; j < clos; j++) {
                matrix[i][j] = array[idx++];
            }
        }
        return matrix;
    }




    /**
     * 链接：https://www.nowcoder.com/questionTerminal/c61c6999eecb4b8f88a98f66b273a3cc
     * 来源：牛客网
     * 解题思路：
     *          （1）
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int flag[] = new int[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, i, j, str, 0, flag))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)
            return false;
        if(k == str.length - 1) return true;
        flag[index] = 1;
        if (helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {
            return true;
        }
        flag[index] = 0;
        return false;
    }

}
