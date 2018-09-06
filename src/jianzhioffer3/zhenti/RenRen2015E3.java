package jianzhioffer3.zhenti;


import jianzhioffer3.TreeNode;

/**
 * @author Mr.Zhang
 * @create 2018-09-06 14:44
 * 题目描述
 * 有一个二叉树， 节点全部为整数，如何找到一个子树，它所有节点的和最大？要求编程序实现。
 */
public class RenRen2015E3 {
    public static void main(String[] args) {
        //手动构建二叉树
        //      1
        //  2       3
        // 4 5       6
        //
        TreeNode root = new TreeNode(-1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(-6);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.right = node5;
        System.out.println(findMax(root));
    }

    private static TreeNode maxRoot = new TreeNode(0);

    /**
     * 存在不足
     * @param root
     * @return
     */
    public static int findMax(TreeNode root){
        if (root == null){
            return 0;
        }else {
            int lSum = findMax(root.left);
            int rSum = findMax(root.right);
            if (maxRoot.val < lSum){
                maxRoot = root.left;
            }
            if (maxRoot.val < rSum){
                maxRoot = root.right;
            }
            return root.val+lSum+rSum;
        }
    }
}
