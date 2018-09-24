package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-23 21:36
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class P25_cloneLinkedList {
    public static void main(String[] args) {

    }

    /**
     * 解题思路：
     * 1、遍历一遍链表复制所有节点，如复制结点A得到A1将A1放到A的后面
     * 2、重新遍历一遍链表，复制老节点的随即指针给新节点，如A1.random = A.random.next
     * 3、拆分链表，将链表拆分成原链表和复制后的链表
     *
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode currentNode = pHead;
        //1、
        while (currentNode != null) {
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            //将复制的节点插入到当前节点的后面
            cloneNode.next = currentNode.next;
            currentNode.next = cloneNode;

            //将当前节点向后移动两位（跳过复制节点）
            currentNode = cloneNode.next;
        }

        //2、
        currentNode = pHead;
        while (currentNode != null) {
            //下一个节点的随即指针指向当前节点的随即指针指向的下一个节点
            currentNode.next.random = currentNode.random == null ? null :
                    currentNode.random.next;

            //将当前节点向后移动两位（跳过复制节点）
            currentNode = currentNode.next.next;
        }

        //3、
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            currentNode = currentNode.next;
        }

        return pCloneHead;
    }
}
