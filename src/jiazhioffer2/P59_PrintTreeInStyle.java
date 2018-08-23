package jiazhioffer2;

import java.util.ArrayList;

/**
 * @Author Zhang
 * @Date 2018/8/23 8:37
 * 题目描述：
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class P59_PrintTreeInStyle {
    public static void main(String[] args) {
        //构建二叉树
        //      1
        //  2       3
        // 4 5       6
        //
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.right = node5;

    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();




        return lists;
    }
}
