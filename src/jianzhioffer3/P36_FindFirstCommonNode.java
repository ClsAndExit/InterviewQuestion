package jianzhioffer3;


import java.util.Stack;

/**
 * @author Mr.Zhang
 * @create 2018-09-24 20:17
 * 题目描述:
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class P36_FindFirstCommonNode {
    public static void main(String[] args) {
        //手动构建链表
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        ListNode head2 = new ListNode(6);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        head2.next = node1;

        //         6---
        //            |
        //1 --> 2 --> 3 --> 4 --> 5
        System.out.println(FindFirstCommonNode2(head, head2).val);
    }

    /**
     * 解题思路：
     * 1、快慢指针 (m+n)-k = (n+m)-k
     * 2、两个链表分别入栈，尾部元素一定相同
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode FindFirstCommonNode(ListNode head1, ListNode head2) {
        ListNode ph1 = head1;
        ListNode ph2 = head2;

        while (ph1 != ph2) {
            ph1 = ph1.next;
            if (ph1 == null) {
                ph1 = head2;
            }
            ph2 = ph2.next;
            if (ph2 == null) {
                ph2 = head1;
            }
        }
        return ph2;
    }

    public static ListNode FindFirstCommonNode2(ListNode head1, ListNode head2) {
        Stack<ListNode> stack1= new Stack<>();
        Stack<ListNode> stack2= new Stack<>();
        while (head1 != null){
            stack1.push(head1);
            head1 = head1.next;
        }
        while (head2 != null){
            stack2.push(head2);
            head2 = head2.next;
        }
        ListNode target = null;
        while (stack1.peek() == stack2.peek()){
            target = stack1.pop();
            stack2.pop();
        }
        return target;
    }
}
