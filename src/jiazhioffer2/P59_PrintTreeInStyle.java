package jiazhioffer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

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
        ArrayList<ArrayList<Integer>> list =Print(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i).toArray()));
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();

        int layer = 1;//用来标记奇偶层
        //s1存奇数层节点
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        s1.push(pRoot);
        //s2存偶数层节点
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        while (!s1.empty() || !s2.empty()){
            //遍历奇数层的节点，将值存入ArrayList，并将下一层的节点压入Stack2
            if (layer % 2 != 0){
                ArrayList<Integer> list = new ArrayList<Integer>();
                while (!s1.empty()){
                    TreeNode node = s1.pop();
                    if (node != null){
                        list.add(node.val);
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if (!list.isEmpty()){
                    lists.add(list);
                    //遍历下一层，修改标识
                    layer++;
                }
            }else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                while (!s2.empty()){
                    TreeNode node = s2.pop();
                    if (node != null){
                        list.add(node.val);
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if (!list.isEmpty()){
                    lists.add(list);
                    //遍历下一层，修改标识
                    layer++;
                }
            }
        }

        return lists;
    }
}
