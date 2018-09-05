package Util;

import jianzhioffer3.ListNode;
import jianzhioffer3.TreeNode;

import java.util.Arrays;

/**
 * @author Mr.Zhang
 * @create 2018-09-02 20:45
 */
public class Print {
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void printLinkList(ListNode head) {
        while (head != null) {
            if (head.next == null) {
                System.out.print(head.val);
            } else
                System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public static void printBinaryTree(TreeNode root){
        if (root != null)
        System.out.println(root.val);
        if (root.left != null)
            printBinaryTree(root.left);
        if (root.right != null)
            printBinaryTree(root.right);
    }
}
