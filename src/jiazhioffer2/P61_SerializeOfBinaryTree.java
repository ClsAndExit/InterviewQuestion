package jiazhioffer2;

/**
 * @Author Zhang
 * @Date 2018/8/23 10:05
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class P61_SerializeOfBinaryTree   {
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

        P61_SerializeOfBinaryTree p61_serializeOfBinaryTree = new P61_SerializeOfBinaryTree();
        String serialize  = p61_serializeOfBinaryTree.Serialize(root);
        TreeNode proot = p61_serializeOfBinaryTree.Deserialize(serialize);
    }

    String Serialize(TreeNode root) {

        return null;
    }
    TreeNode Deserialize(String str) {
        return null;
    }
}
