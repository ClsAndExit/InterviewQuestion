package jiazhioffer2;

import java.util.ArrayList;

/**
 * @Author Zhang
 * @Date 2018/8/23 11:18
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 *
 */
public class P62_KthNode {
    public static void main(String[] args) {
//构建二叉树
        //      1
        //  2       3
        // 4 5       6
        //
        //      1,2,4,#,#,5,#,#,3,#,6,#,#,
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(8);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.right = node6;
        node2.left  = node5;

        print(root);
        System.out.println();
        System.out.println(KthNode2(root,3).val);

    }
    public static void print (TreeNode root){
        if (root.left != null ){
            print(root.left);
        }
        System.out.print(root.val+",");
        if (root.right!= null){
            print(root.right);
        }
    }
    static int index;

    /**
     * 方法一：二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。所以，按照中序遍历顺序找到第k个结点就是结果。
     * 方法二：使用一个List，将所有元素都遍历一遍，压入List中，然后在取第K个
     *      （复杂度比较高,需要所有元素都访问一遍，而不是像方法一，取到第K个就停止了）
     * @param pRoot
     * @param k
     * @return
     */
    public static TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot != null) {
            TreeNode node = KthNode(pRoot.left, k);
            if (node != null) {
                return node;
            }
            index++;
            if (index == k) {
                return pRoot;
            }
            node = KthNode(pRoot.right, k);
            if (node != null) {
                return node;
            }
        }
        return null;
    }

    public static TreeNode KthNode2(TreeNode pRoot, int k){
        ArrayList<TreeNode> nodeArrayList = new ArrayList<TreeNode>();
        if (pRoot == null || k<0){
            return null;
        }
        Insert(pRoot,nodeArrayList);
        if (k>nodeArrayList.size())
            return null;
        return nodeArrayList.get(k-1);
    }

    public static void Insert(TreeNode pRoot,ArrayList<TreeNode> nodeArrayList){
        if (pRoot == null){
            return;
        }
        Insert(pRoot.left,nodeArrayList);
        nodeArrayList.add(pRoot);
        Insert(pRoot.right,nodeArrayList);
    }
}
