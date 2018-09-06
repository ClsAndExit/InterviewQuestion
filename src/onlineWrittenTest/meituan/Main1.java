package onlineWrittenTest.meituan;

import java.util.Scanner;

/**
 * @author Mr.Zhang
 * @create 2018-09-06 20:03
 *
 * 给定一张包含N个点、N-1条边的无向连通图，节点从1到N编号，每条边的长度均为1。假设你从1号节点出发并打算遍历所有节点，那么总路程至少是多少？
 * 输入
 * 第一行包含一个整数N，1≤N≤100000。
 * 接下来N-1行，每行包含两个整数X和Y，表示X号节点和Y号节点之间有一条边，1≤X，Y≤N。
 * 输出
 * 输出总路程的最小值。
 */
public class Main1 {
    /**
     * 走完所有节点类似于深度优先搜索，也就是说除了最后一条路径外，别的路径都经历了正着走，再返回
     * 的过程，也就是两遍，设最后一条路径为x，总分支数为n-1，总路径=2*(n-1-x)+x=2*n-2-x，当x最大时
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        int[] lis = new int[n+1];
        int [][] martix = new int[n][2];
        for (int i = 0; i < n-1 ; i++) {
            int a = martix[i][0] = scanner.nextInt();
            int b = martix[i][1] = scanner.nextInt();

            lis[b] = lis[a]+1;//最大深度
        }
        int depth = 0;
        for (int i = 1; i <n+1 ; i++) {
            depth = Math.max(depth,lis[i]);
        }
        System.out.println(2*n-2-depth);
    }

}
