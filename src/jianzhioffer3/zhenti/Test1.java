package jianzhioffer3.zhenti;

import jianzhioffer3.TreeNode;

/**
 * @author Mr.Zhang
 * @create 2018-09-05 19:19
 */
public class Test1 {
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
        System.out.println(find(root,2));

    }
    public static int find(TreeNode root,int val){
        int i = 0,j = 0;
        if (root == null)
            return 0;
        if (root.val == val)
            return 1;
        i = find(root.left,val);
        j = find(root.right,val);
        if (i!=0)
            return i+1;
        if (j!=0)
            return j+i;
        else return 0;
    }
}
