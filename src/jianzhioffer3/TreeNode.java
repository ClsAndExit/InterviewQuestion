package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-01 16:11
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

/*
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
 */
