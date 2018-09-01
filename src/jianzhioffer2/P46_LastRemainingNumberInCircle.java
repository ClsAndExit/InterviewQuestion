package jianzhioffer2;

/**
 * @Author Zhang
 * @Date 2018/8/18 10:06
 * 题目描述
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
 *      首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 *      --每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 *      --从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
 *      可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 *      请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class P46_LastRemainingNumberInCircle {
    public static void main(String[] args) {

        int lucklyChild = LastRemainingNumberInCircle(5,2);
        System.out.println(lucklyChild);
    }

    /*约瑟夫问题，求递推公式，每轮的序列中最后出序列的数都是同一个*/
    public int LastRemaining_Solution(int n,int m) {
        if(n < 1 || m < 1)
            return -1;
        if(n == 1){
            return 0;
        }
        return (LastRemaining_Solution(n-1, m)+m)%n;
    }

    /**
     * 方法一：循环链表实现
     *        （1）模拟现实场景，头节点执行M-1步之后，当前的节点退出链表
     * @param n
     * @param m
     * @return
     */
    public static int LastRemainingNumberInCircle (int n,int m){
        if(n == 0){
            return -1;
        }
        //这是一个节点数量为n的循环链表
        ListNode head= createCircularListNode(n);
        //设置一个游标指针标记链表中的位置
        ListNode pHead = head;
        //当循环链表中仅剩最后一个节点的时候结束循环
        while (head.next != head){
            pHead = head;
            for (int i = 0; i < m-1; i++) {

                pHead = pHead.next;
            }
            head = deleteCircularListNode(head,pHead);
        }
        return head.val;
    }

    /**
     * 在循环链表中删除一个节点
     * @param node
     * @return
     */
    public static ListNode deleteCircularListNode(ListNode head,ListNode node){
        while (head.next != node){
            head = head.next;
        }
        head.next = node.next;
        //删除完该节点之后，head应该从删除掉的节点的下一个节点开始
        head = head.next;
        return head;
    }
    /**
     * 创建一个节点个数为n的循环链表
     * @param n
     * @return
     */
    public static ListNode createCircularListNode(int n){
        //使用temp来记录上一个节点，并指向当前节点
        ListNode temp = new ListNode();
        ListNode head = new ListNode(0);
        //通过一组数，形成一个环形链表
        for (int i = 1; i < n; i++) {
            if (i == 1){//在起始位置加入头节点
                ListNode node = new ListNode(i);
                head.next = node;
                temp = node;
            }else if (i == n-1){//在结束位置指向头节点形成环
                ListNode node = new ListNode(i);
                temp.next = node;
                node.next = head;
            }else {
                ListNode node = new ListNode(i);
                temp.next = node;
                temp = node;
            }
        }
        return head;
    }
}
