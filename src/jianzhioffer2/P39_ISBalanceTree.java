package jianzhioffer2;

/**
 * @Author Zhang
 * @Date 2018/8/17 14:21
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 */
public class P39_ISBalanceTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        //构建平衡二叉树
        //      1
        //  2       3
        // 4 5       6
        //
//        root.left = node1;
//        root.right = node2;
//
//        node1.left = node3;
//        node1.right = node4;
//
//        node2.right = node5;
//
//        //构建不平衡二叉树
//        //      4
//        //  2
//        // 1 3
//        //5   6
//
//        System.out.println(IsBalanceTree(root));

//        node3.left = node1;
//
//        node1.left = root;
//        node1.right = node2;
//
//        root.left = node4;
//        node2.right = node5;

        P39_ISBalanceTree p39_isBalanceTree = new P39_ISBalanceTree();
        System.out.println(p39_isBalanceTree.IsBalanceTree(root));
    }

    /**
     *  平衡二叉树（Balanced Binary Tree）又被称为AVL树（有别于AVL算法），且具有以下性质：
     *      它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
     *  这个方案很好的解决了二叉查找树退化成链表的问题，把插入，查找，删除的时间复杂度最好情况和最坏情况都维持在O(logN)。
     *      但是频繁旋转会使插入和删除牺牲掉O(logN)左右的时间，不过相对二叉查找树来说，时间上稳定了很多。
     * @param root
     * @return
     */
    //在提交代码的时候这里报错，
    // 因为静态变量只会初始化一次，在执行多个测试用例的时候，后面的改变将会被忽略
    static boolean isBalance = true;
    public  boolean IsBalanceTree(TreeNode root){
        getDepth(root);
        return isBalance;
    }

    public  int getDepth(TreeNode root){
        if (root == null)
            return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if(Math.abs(left-right) > 1){
            isBalance = false;
        }
        return right>left?right+1:left+1;
    }
}
