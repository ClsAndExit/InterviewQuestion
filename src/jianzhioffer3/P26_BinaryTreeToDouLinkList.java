package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-24 10:02
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class P26_BinaryTreeToDouLinkList {
    public static void main(String[] args) {

    }

    /**
     * 因为是BST，中序排序就是排序的了
     *
     *
     * @param pRootOfTree
     * @return
     */
    static TreeNode head = null;
    static TreeNode realHead = null;
    public static TreeNode Convert(TreeNode pRootOfTree) {
        convertHelp(pRootOfTree);
        return realHead;
    }

    /**
     * right指向后一节点
     * left指向前一个节点
     * realHead用来标记头结点（因为head只有一次是为null的）
     * head用来标记当前节点，是随着递归不断改变的
     * @param pRootOfTree
     */
    public static void convertHelp(TreeNode pRootOfTree){
        if (pRootOfTree == null)
            return;
        convertHelp(pRootOfTree.left);
        //左子树中没有节点
        if (head == null){
            head = pRootOfTree;
            realHead = pRootOfTree;
        }else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        convertHelp(pRootOfTree.right);
    }
}
