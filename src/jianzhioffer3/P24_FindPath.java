package jianzhioffer3;

import java.util.ArrayList;

/**
 * @author Mr.Zhang
 * @create 2018-09-09 13:00
 *
 * 题目描述
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class P24_FindPath {
    public static void main(String[] args) {
        //手动构建二叉树
        //      1
        //  2       3
        // 4 6       5
        //2
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(2);

        root.left = node2;
        root.right = node1;

        node1.left = node3;
        node1.right = node5;

        node2.right = node4;
        node3.left = node6;

        P24_FindPath p24_findPath = new P24_FindPath();
        p24_findPath.FindPath(root,9);
        for (int i = 0; i < p24_findPath.allPath.size(); i++) {
            for (int j = 0; j < p24_findPath.allPath.get(i).size(); j++) {
                System.out.print(","+p24_findPath.allPath.get(i).get(j));
            }
            System.out.println();
        }
    }

    private   ArrayList<ArrayList<Integer>> allPath = new ArrayList<ArrayList<Integer>>();
    private   ArrayList<Integer> list = new ArrayList<>();
    public   ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null){
            return allPath;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null){
            allPath.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size() - 1);
        return allPath;
    }

    //数组长的靠前
    public void sort(){

    }
}
