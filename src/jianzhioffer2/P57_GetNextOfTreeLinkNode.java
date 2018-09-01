package jianzhioffer2;

/**
 * @Author Zhang
 * @Date 2018/8/22 14:45
 *
 *     int val;
 *     TreeLinkNode left = null;
 *     TreeLinkNode right = null;
 *     TreeLinkNode next = null;
 *
 *     TreeLinkNode(int val) {
 *         this.val = val;
 *     }
 *
 *
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class P57_GetNextOfTreeLinkNode {
    public static void main(String[] args) {

        //构建二叉树
        //      4
        //  2       6
        // 1 3     5  7
        //

        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);

        node4.left = node2;
        node2.left = node1;
        node2.right = node3;
        node2.next = node4;
        node1.next = node2;
        node3.next = node2;

        node4.right = node6;
        node6.right = node7;
        node6.left = node5;
        node6.next = node4;
        node5.next = node6;
        node7.next = node6;

        System.out.println(GetNext(node1).val);
        System.out.println(GetNext(node2).val);
        System.out.println(GetNext(node3).val);
        System.out.println(GetNext(node4).val);
        System.out.println(GetNext(node5).val);
        System.out.println(GetNext(node6).val);
        //7已经是最后一个节点，没有下一节点了
        System.out.println(GetNext(node7).val);
    }

    /**
     * 分不同情况进行分析：
     * 1、该节点有右子树，则一直遍历该节点的右子树的左子树，直到到达叶子节点（如构建的图中的节点2，节点4，节点6）
     * 2、节点不是根节点
     *      （1）该节点是其父节点的左孩子，则直接返回父节点（如图中节点1，节点5）
     *      （2）否则，一直向上遍历其父节点的父节点，
     *      若该节点的父节点是父节点的父节点的左孩子，则返回父节点的父节点（如图中节点3）
     * @param pNode
     * @return
     */
    public static TreeLinkNode GetNext(TreeLinkNode pNode){
        if (pNode == null){
            return pNode;
        }else {
            if (pNode.right != null){
                pNode = pNode.right;
                while (pNode.left != null){
                    pNode = pNode.left;
                }
                return pNode;
            }
            while (pNode.next != null){
                TreeLinkNode newNode = pNode.next;
                if (newNode.left == pNode){
                    return newNode;
                }
                pNode = pNode.next;
            }
        }
        return new TreeLinkNode(-1);
    }
}
