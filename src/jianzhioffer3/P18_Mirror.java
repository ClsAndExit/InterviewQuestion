package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-05 10:06
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class P18_Mirror {
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

        Util.Print.printBinaryTree(root);
        System.out.println("after Mirror");
        Mirror(root);
        Util.Print.printBinaryTree(root);
    }
    public static void Mirror(TreeNode root) {
        if (root== null)
            return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
