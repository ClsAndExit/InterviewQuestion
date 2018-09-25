package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-25 10:17
 *
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class P39_IsBalanced {
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

        System.out.println(IsBalanced(root));
    }

    /**
     * 平衡二叉树（Balanced Binary Tree），具有以下性质：
     * 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
     * @param root
     * @return
     */
    public static boolean IsBalanced(TreeNode root){
        return getDepth(root) != -1;
    }

    private static int getDepth(TreeNode root){
        if (root == null)
            return 0;
        int left = getDepth(root.left);
        if (left == -1)
            return -1;
        int right = getDepth(root.right);
        if (right == -1)
            return -1;
        return Math.abs(left-right) > 1?-1:1+Math.max(left,right);
    }
}
