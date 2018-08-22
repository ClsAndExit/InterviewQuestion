package jiazhioffer2;

/**
 * @Author Zhang
 * @Date 2018/8/21 10:37
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class P55_EntryNodeOfLoop {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
       // node7.next = node3;
//
//        for (int i = 0; i < 20; i++) {
//            System.out.println(head.val);
//            head = head.next;
//        }
        System.out.println(EntryNodeOfLoop1(head).val);
      //  System.out.println(EntryNodeOfLoop2(head));
      //  System.out.println(EntryNodeOfLoop3(head));

    }

    /**
     * 方法一：断链:这种方法存在一定的缺陷，无环时返回的是最后一个节点而不是题目中要求的null
     * 方法二：set元素不能相同）或者使用（map标记节点出现的次数
     * 方法三：快慢指针
     * @param pHead
     * @return
     */
    public static ListNode EntryNodeOfLoop1 (ListNode pHead){
        if(pHead==null|| pHead.next==null){
            return null;
        }
        ListNode fast=pHead.next;
        ListNode slow=pHead;
        while(fast!=null){
            slow.next=null;
            slow=fast;
            fast=fast.next;
        }
        return slow;
    }

    public static ListNode EntryNodeOfLoop2 (ListNode pHead){

        return new ListNode();
    }

    public static ListNode EntryNodeOfLoop3 (ListNode pHead){

        return new ListNode();
    }
}
