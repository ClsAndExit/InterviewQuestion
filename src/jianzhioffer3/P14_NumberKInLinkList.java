package jianzhioffer3;

import java.util.List;

/**
 * @author Mr.Zhang
 * @create 2018-09-04 16:07
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class P14_NumberKInLinkList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode newHead = Find(head, 2);
        System.out.println(newHead.val);
        System.out.println("链表是长这个样子的");
        Util.Print.printLinkList(head);
    }

    /**
     * 方法一：使用快慢指针
     * （1）首先定义两个指针，
     * （2）让快指针先走k步
     * （3）快慢指针同时出发，当快指针到达末尾，慢指针恰好到达倒数第k个位置
     * 方法二：使用栈：压栈，再吐出来（n-k+1）就是所求
     * 方法三：使用递归实现
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
        ListNode slow = head;
        ListNode quick = head;
        for (int i = 0; i < k; i++) {
            if (quick == null) {
                return null;
            } else
                quick = quick.next;
        }
        while (quick != null) {
            quick = quick.next;
            slow = slow.next;
        }
        return slow;
    }


    static int cnt = 0;

    /**
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode Find (ListNode head,int k){
        if (head == null){
            return null;
        }
        ListNode node = Find(head.next,k);
        if (node != null)
            return node;
        cnt ++;
        if (cnt==k){
            return head;
        }else {
            return null;
        }
    }

}
