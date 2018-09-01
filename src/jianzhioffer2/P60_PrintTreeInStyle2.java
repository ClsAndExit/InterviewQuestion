package jianzhioffer2;

import java.util.*;

/**
 * @Author Zhang
 * @Date 2018/8/23 9:32
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class P60_PrintTreeInStyle2 {
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
        ArrayList<ArrayList<Integer>> list =Print(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i).toArray()));
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null){
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        ArrayList<Integer> list = new ArrayList<Integer>();
        //用来标记队列中不同行的节点
        int start =0,end =1;
        while (!queue.isEmpty()){
            TreeNode tmp = queue.remove();
            list.add(tmp.val);
            start++;
            if (tmp.left!= null){
                queue.add(tmp.left);
            }
            if (tmp.right != null){
                queue.add(tmp.right);
            }
            if (start == end){
                lists.add(list);
                end = queue.size();
                start =0;
                list = new ArrayList<Integer>();
            }
        }
        return lists;
    }
}
