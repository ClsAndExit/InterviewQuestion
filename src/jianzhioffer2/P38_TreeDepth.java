package jianzhioffer2;

/**
 * @Author Zhang
 * @Date 2018/8/17 11:02
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class P38_TreeDepth {
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

        System.out.println(TreeDepth(root));
    }

    /**
     * 方法一：遍历二叉树，维护深度的最大值
     * @param root
     * @return
     */
    public static int TreeDepth (TreeNode root){
        int deep = 1;
        if (root == null){
            return 0;
        }
        deep += Math.max(TreeDepth(root.left),TreeDepth(root.right));
        return deep;
    }
}
