package jiazhioffer2;

public class P_25CopylinkList {
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
