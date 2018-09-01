package jianzhioffer2;

/**
 * @Author Zhang
 * @Date 2018/8/16 19:11
 *
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点
 */
public class P36_FindFirstCommonNode {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(7);
        ListNode node6 = new ListNode(8);
        ListNode node7 = new ListNode(9);

        head1.next = node1;
        node1.next = node3;
        node3.next = node5;

        head2.next = node2;
        node2.next = node4;
        node4.next = node5;

        node5.next = node6;
        node6.next = node7;

//        printLinkList(head1);
//        printLinkList(head2);

        printLinkList(FindFirstCommonNode(head1,head2));
    }

    /**
     * 由于是单链表，当两个链表有公共节点之后，两个链表在此处之后将会使用公共的尾部
     * 从这个条件可以得出以下几点：
     *      1、公共尾部的长度相同，并且使用的是公共的节点（内存地址相同）
     *      2、不能通过节点的值(node.value)进行比较（链表中允许值相同的节点）
     * 方法一：从前往后找
     *      （1）分别计算两个链表的长度L1,L2；
     *      （2）计算两个链表的长度差d=L1-L2；
     *      （3）让较长的链表先走d步
     *      （4）两个链表同时往下走，直到到达公共节点时停止（head1 == head2   注意：不是值相等，是对象相等），没有则都为null
     * 方法二：从后往前找
     *      （1）将两个链表分别入栈
     *      （2）由于两个链表使用的是公共的尾部节点，所以栈顶元素必然相等（没有公共节点则都为null）
     *      （3）两个栈同时拿出栈顶元素进行比较，如果相等则将此元素出栈，然后比较下一个
     *      （4）直到栈顶元素不相等时，返回上一个栈顶元素即可。
     * 方法三：前面提到的两种方法都是指针各自在自己的那一条链上面移动，第三种方法则是在两条链表之间交叉交换指针
     *      （1）声明两个指针，分别指向pHead1和pHead2；
     *      （2）两个指针同时向后运行
     *      （3）若两个链表长度相等，则运行到公共节点就停止并返回该节点
     *           若两个链表长度不相等，则先运行到尾部的指针指向另外一个链表的头节点
     *      （4）先运行到尾部，并且指向另外一条链表的指针原来所在的链表一定是较短的那一条，当它重新指向另外一条链表之后继续运行
     *           等到原来指向较长链表的那一个指针也运行到尾部最后一个节点，则该指针指向较短那一条链表的头部，然后继续向后运行
     *           此时可以用一个公式来表示{b-(b-a)=1}这里的b指的是较长链表的长度，a指的是较短链表的长度
     *      （5）当另外一个指针也重新指向较短链表的头部之后，两个指针同时向后运行（较短链表的长度-公共部分的长度）步之后即可到达公共节点
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static ListNode FindFirstCommonNode(ListNode pHead1,ListNode pHead2){
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != p2){
            if (p1!=null)
                p1 = p1.next;
            else
                p1 = pHead2;
            if (p2!=null)
                p2 = p2.next;
            else
                p2 = pHead1;
        }
        return p2;
    }

    public static void printLinkList(ListNode head){
        while (head!=null){
            System.out.print(head+"-------");
            System.out.print(head.val);
            System.out.println(",");
            head = head.next;
        }
    }
}
