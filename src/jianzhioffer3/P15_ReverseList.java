package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-04 21:46
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class P15_ReverseList {
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

        System.out.println("原始链表：");
        Util.Print.printLinkList(head);
        //ListNode newNode = ReverseList(head);
        ListNode newNode = reverse(head);
        System.out.println("反转之后：");
        Util.Print.printLinkList(newNode);
    }

    /**
     * 方法一：非递归方法
     * （1）设置两个ListNode结点用来存储当前节点的前一个结点和后一个节点，命名为pre和next；
     * （2）pre next head->node1->node2
     * （3）next = head.next = node1,head.next = pre 将head的指针反转之后，链表长成下面这个样子
     * pre<-head  node1->node2
     * next(也就是node1)->node2(这两个是同一个node2)
     * （4）然后将head、pre这两个结点都向后移动一位
     * pre = head   head = next  执行完之后长成下面这个样子
     * null<-pre(原来的head)  head(原来的next，也就是node1)->node2
     * 再次进入循环   head(原来的next，也就是node1)->next(也就是原来的node2)
     * （5）继续向后运行就是不断断开链表、链接链表、指针后移的重复过程。
     * （6）运行到最后应该返回pre为新链表的头结点。
     *
     * @param phead
     * @return
     */
    public static ListNode ReverseList(ListNode phead) {
        ListNode pre = null;
        ListNode next = null;
        while (phead != null) {
            next = phead.next;
            phead.next = pre;

            pre = phead;
            phead = next;
        }
        return pre;
    }

    /**
     * 递归方法实现
     *
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        //到达倒数第二个结点为递归底部
        if (head == null || head.next == null)
            return head;
        ListNode reverseNode = reverse(head.next);

        //递归回退的时候执行下列语句
        /**
         * 这两句话的意思画图非常容易理解
         * 原始链表： 1->2->3->4->5
         * 执行两句： 1->2->3->4<-5
         * 然后一点点回退就可以了
         */
        head.next.next = head;
        head.next = null;

        return reverseNode;
    }
}
