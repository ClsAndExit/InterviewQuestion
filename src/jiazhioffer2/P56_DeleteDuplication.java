package jiazhioffer2;

/**
 * @Author Zhang
 * @Date 2018/8/22 9:58
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class P56_DeleteDuplication {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(6);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode pHead = deleteDuplication1(head);
        while (pHead!= null){
            System.out.println(pHead.val);
            pHead = pHead.next;
        }
    }

    /**
     * 方法一：双指针
     * 方法二：hashMap记录节点出现次数，然后重新构建链表
     * 方法三：
     * @param pHead
     * @return
     */

    public static ListNode deleteDuplication1(ListNode pHead){
        if (pHead == null || pHead.next == null){
            return pHead;
        }else {
            ListNode newNode = new ListNode(-1);
            newNode.next = pHead;
            ListNode pre  = newNode;
            ListNode p = pHead;
            ListNode next = null;
            while (p!=null && p.next!=null){
                next = p.next;
                if (p.val == next.val){
                    while (next != null && next.val == p.val){
                        next = next.next;
                    }
                    pre.next = next;
                    p = next;
                }else {
                    pre = p;
                    p = p.next;
                }
            }
            return newNode.next;
        }
    }

    public static ListNode deleteDuplication(ListNode pHead){
        //只有0个或者1个节点，则直接返回
        if (pHead == null || pHead.next == null){
            return pHead;
        }
        //当前节点是重复节点
        if (pHead.val == pHead.next.val){
            ListNode node = pHead.next;
            while (node != null && node.val == pHead.val){
                //跳过值与当前节点相同的所有节点，找到第一个与当前节点不同的节点
                node = node.next;
            }
            //从第一个与当前节点不同的节点开始递归
            return deleteDuplication(node);
        }else{//当前节点不是重复节点
            //保留当前节点，从下一个节点开始递归
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}


















