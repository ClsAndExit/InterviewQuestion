package jianzhioffer3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Mr.Zhang
 * @create 2018-09-01 15:53
 * 题目描述
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class P3_PrintListFromTailToHead {
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

        List<Integer> list = printListFromTailToHead3(head);
        for (int i:list) {
            System.out.println(i);
        }
    }

    /**
     * 方法一：利用栈数据结构的特点
     * 方法二：先反转链表再顺序遍历
     * 方法三：利用递归
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<ListNode> listNodes = new Stack<ListNode>();
        while (listNode!=null){
            listNodes.push(listNode);
            listNode = listNode.next;
        }
        while (!listNodes.empty()){
            list.add(listNodes.pop().val);
        }
        return list;
    }

    static ArrayList<Integer> list = new ArrayList<Integer>();
    public static ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        if (listNode != null){
            printListFromTailToHead3(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}
