package jianzhioffer3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Mr.Zhang
 * @create 2018-09-24 21:51
 * 题目描述
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class P38_TreeDepth {
    public static void main(String[] args) {
        //手动构建二叉树
        //      1
        //  2       3
        // 4 5        6
        //              7
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.right = node5;
        node5.right = node6;
        System.out.println(TreeDepth1(root));
    }

    /**
     * 解题思路：
     * 1、递归实现
     * 2、非递归，层次遍历
     *
     * @param root
     * @return
     */
    public static int TreeDepth1(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth = 0,count = 0,nextCount = 1;
        while (queue.size() != 0){
            TreeNode top = queue.poll();
            count++;
            if (top.left != null){
                queue.add(top.left);
            }
            if (top.right != null){
                queue.add(top.right);
            }
            if (count == nextCount){
                nextCount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
    }


    public static int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = TreeDepth(root.left) + 1;
        int rightDepth = TreeDepth(root.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }
}
