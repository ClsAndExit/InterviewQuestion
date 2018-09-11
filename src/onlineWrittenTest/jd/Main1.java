package onlineWrittenTest.jd;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Mr.Zhang
 * @create 2018-09-09 19:01
 *
 * 题目描述：
 * 给定一张包含N个点、M条边的无向图，每条边连接两个不同的点，且任意两点间最多只有一条边。
 * 对于这样的简单无向图，如果能将所有点划分成若干个集合，使得任意两个同一集合内的点之间没有边相连，
 * 任意两个不同集合内的点之间有边相连，则称该图为完全多部图。现在你需要判断给定的图是否为完全多部图。
 *
 * 输入
 * 第一行输入一个整数T表示数据组数，1≤T≤10。
 *
 * 每组数据格式为：
 *
 * 第一行包含两个整数N和M，1≤N≤1000，0≤M≤N(N-1)/2；
 *
 * 接下来M行，每行包含两个整数X和Y，表示第X个点和第Y个点之间有一条边，1≤X，Y≤N。
 *
 * 输出
 * 每组输出占一行，如果给定的图为完全多部图，输出Yes，否则输出No。
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int teams = scanner.nextInt();//1≤T≤10

        ArrayList<Integer> list = new ArrayList<>();
    }
}
