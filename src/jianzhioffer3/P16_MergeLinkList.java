package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-05 9:02
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则.
 */
public class P16_MergeLinkList {
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

        ListNode head2 = new ListNode(4);
        ListNode node12 = new ListNode(5);
        ListNode node22 = new ListNode(13);
        ListNode node32 = new ListNode(14);
        ListNode node42 = new ListNode(15);
        head2.next = node12;
        node12.next = node22;
        node22.next = node32;
        node32.next = node42;
        System.out.println("链表1");
        Util.Print.printLinkList(head);
        System.out.println("链表2");
        Util.Print.printLinkList(head2);
        System.out.println("合并之后链表");
        Util.Print.printLinkList(Merge1(head, head2));
    }

    /**
     * 方法一：递归实现
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val < list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    /**
     * 方法二：非递归实现
     * 思路：
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge1(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode mergeHead = null;
        ListNode current = null;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val){
                if (mergeHead == null){
                    mergeHead = current = list1;
                }else {
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            }else {
                if (mergeHead == null){
                    mergeHead = current = list2;
                }else {
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }

        if (list1 == null) {
            current.next = list2;
        } else {
            current.next = list1;
        }
        return mergeHead;
    }
}
