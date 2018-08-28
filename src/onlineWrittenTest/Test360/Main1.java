package onlineWrittenTest.Test360;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有一个城市需要修建，给你N个民居的坐标X,Y，问把这么多民居全都包进城市的话，
 * 城市所需最小面积是多少（注意，城市为平行于坐标轴的正方形）
 *
 * 输入
 * 第一行为N，表示民居数目（2≤N≤1000）
 *
 * 下面为N行，每行两个数字Xi，Yi，表示该居民的坐标（-1e9≤xi,yi≤1e9）
 *
 * 输出：
 * 城市所需最小面积
 *
 * 样例输入：
 * 2
 * 0 0
 * 2 2
 * 样例输出：
 * 4
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int  countOfPeople = scan.nextInt();
        int [][] localOfPeople = new int [countOfPeople][2];
        for (int i = 0; i < countOfPeople; i++) {
            localOfPeople[i][0] = scan.nextInt();
            localOfPeople[i][1] = scan.nextInt();
        }
        if (localOfPeople == null || localOfPeople[0].length<=0){
            System.out.println("error");
        }else
             System.out.println(spaceOfCity(localOfPeople));
    }

    /**
     * 计算把所有坐标包含在内的正方形面积
     * 简单来看正方形其中的一条边是和X轴或者Y轴是重合的
     * 根据题中给出的样例2来看，不需要考虑正方形是倾斜放置的情况
     * 解题思路：
     * 首先计算出二维矩阵中所有点之间的距离
     * 然后选取距离最大的那条边作为正方形的边
     * 然后计算出面积返回即可
     * @param local
     * @return
     */
    public static int spaceOfCity(int[][] local){
        if (local == null || local[0].length<=0){
            return 0;
        }
        int space = 0;
        int length = local.length;
        int index = 0;
        int[] distance = new int[length*(length+1)/2];
        for (int i = 0; i < local.length; i++) {
            for (int j = i+1; j < local.length; j++) {
                distance[index] = distance(local[i],local[j]);
            }
        }
        Arrays.sort(distance);
        space = distance[distance.length-1];
        return space*space;
    }

    /**
     * 计算两点之间的距离
     * 解题思路：
     * 由于计算正方形的时候不需要考虑倾斜情况，所以我们在计算两点之间距离的时候只需要计算横纵坐标之差即可
     * @param local1
     * @param local2
     * @return
     */
    public static int distance (int[] local1,int[] local2){
        int distance = 0;
        int dsi_x = Math.abs(local1[0] - local2[0]);
        int dsi_y = Math.abs(local1[1] - local2[1]);
        distance = Math.max(dsi_x,dsi_y);
        return distance;
    }
}
