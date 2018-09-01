package jianzhioffer3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Mr.Zhang
 * @create 2018-09-01 16:10
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class P4_ReConstructBinaryTree {
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = reConstructBinaryTree(pre, in);
        print(root);
        System.out.println("******************");
        print2(root);
        System.out.println("******************");
        print3(root);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length <= 0 || in.length <= 0 || pre.length != in.length) {
            return null;
        }
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd,
                                                 int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode node = new TreeNode(pre[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (pre[preStart] == in[i]) {
                node.left = reConstructBinaryTree(pre, preStart + 1, preStart + i - inStart,
                        in, inStart, i - 1);
                node.right = reConstructBinaryTree(pre, i - inStart + preStart + 1, preEnd,
                        in, i + 1, inEnd);
            }
        }
        return node;
    }

    /**
     * 遍历二叉树
     * 方法一：递归
     * 方法二：层次
     * 方法三：非递归
     *
     * @param root
     */
    public static void print(TreeNode root) {
        System.out.println(root.val);
        if (root.left != null) {
            print(root.left);
        }
        if (root.right != null) {
            print(root.right);
        }
    }

    public static void print2(TreeNode root) {
        Queue<TreeNode> treeNodes = new LinkedList<TreeNode>();
        ((LinkedList<TreeNode>) treeNodes).offer(root);
        while (!treeNodes.isEmpty()) {
            TreeNode node = ((LinkedList<TreeNode>) treeNodes).poll();
            System.out.println(node.val);
            if (node.right != null) {
                ((LinkedList<TreeNode>) treeNodes).offer(node.right);
            }
            if (node.left != null) {
                ((LinkedList<TreeNode>) treeNodes).offer(node.left);
            }
        }
    }

    /**
     * 非递归的三种方式
     * 前序、中序、后序
     * 参考博客：https://blog.csdn.net/zfyseu1/article/details/73992045
     * @param root
     */
    public static void print3(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            TreeNode remove = stack.removeLast();
            System.out.println(remove.val);
            if (remove.right != null) {
                stack.addLast(remove.right);
            }
            if (remove.left != null) {
                stack.addLast(remove.left);
            }
        }
    }

    public static void print4(TreeNode root) {

    }

    public static void print5(TreeNode root) {

    }
}
