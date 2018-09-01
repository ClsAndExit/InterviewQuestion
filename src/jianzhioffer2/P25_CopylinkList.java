package jianzhioffer2;

/**
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class P25_CopylinkList {
    public static void main(String[] args) {

    }

    public static RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null){
            return null;
        }

        //在节点后面加入新节点（复制next指针,建立next链接）
        RandomListNode nextNode = pHead;

        while (nextNode != null){
            RandomListNode clone = new RandomListNode(nextNode.label);
            clone.next = nextNode.next;
            nextNode.next = clone;
            nextNode = clone.next;
        }

        //建立random连接
        nextNode = pHead;
        while (nextNode != null){
            RandomListNode clone = nextNode.next;
            if(nextNode.random!=null){
                clone.random = nextNode.random.next;
            }
            nextNode = clone.next;
        }

        //拆分
        nextNode = pHead;
        RandomListNode cloneHead = pHead.next;
        while (nextNode.next!=null){
            RandomListNode next = nextNode.next;
            nextNode.next = next.next;
            nextNode = next;
        }

        return cloneHead;
    }
}
