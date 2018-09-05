package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-05 9:38
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class P17_HasSubtree {
    public static void main(String[] args) {
        //手动构建二叉树
        //      0
        //  1       2
        // 3 4       5
        //
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;

        //手动构建二叉树
        //  1
        // 3 4

        TreeNode root1 = new TreeNode(1);
        TreeNode node31 = new TreeNode(3);
        TreeNode node41 = new TreeNode(4);

        root1.left = node31;
        root1.right = node41;

        System.out.println(HasSubtree(root,root1));
    }

    /**
     *
     * @param root1
     * @param root2
     * @return
     */
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }
        if (isSubTree(root1,root2) || HasSubtree(root1.right,root2)
                || HasSubtree(root1.left,root2)){
            return true;
        }
        return false;
    }

    public static boolean isSubTree(TreeNode root1,TreeNode root2){
        //如果root1和root2 同时为空应该返回true，所以应该将root1的判空放在root2后面
        if (root2 == null){
            return true;
        }
        if (root1 == null){
            return false;
        }
        if (root1.val == root2.val){
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        }else {
            return false;
        }
    }
}
