package jianzhioffer3;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Mr.Zhang
 * @create 2018-09-09 9:50
 *
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class P22_PrintFromTopToBottom {
    public static void main(String[] args) {
        //手动构建二叉树
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
        ArrayList<Integer> list = PrintFromTopToBottom(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * 层次遍历，借助队列
     * @param root
     * @return
     */
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null){
            queue.add(root);
        }else {
            return null;
        }
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        return list;
    }
}
