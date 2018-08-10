package jiazhioffer2;

public class P26_BSTtoLinkList {
    public static void main(String[] args) {
        TreeNode root= new TreeNode(5);
        TreeNode leftNode= new TreeNode(3);
        TreeNode rightNode= new TreeNode(7);
        TreeNode leftNode1= new TreeNode(2);
        TreeNode rightNode1= new TreeNode(4);
        TreeNode leftNode2= new TreeNode(6);
        TreeNode rightNode2= new TreeNode(8);

        root.left = leftNode;
        root.right = rightNode;
        leftNode.left = leftNode1;
        leftNode.right = rightNode1;
        rightNode.left = leftNode2;
        rightNode.right = rightNode2;

        P26_BSTtoLinkList p26_bsTtoLinkList = new P26_BSTtoLinkList();

        TreeNode linkList = p26_bsTtoLinkList.Convert(root);
        while (linkList != null){
            System.out.println(linkList.val);
            linkList = linkList.right;
        }
    }
    private TreeNode pre = null;
    private TreeNode head = null;
    public  TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        inOrder(pRootOfTree);
        return head;
    }

    //按照中序遍历从小往大找
    public  void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        node.left = pre;
        if(pre !=null){
            pre.right = node;
        }
        pre  =node;
        if(head == null){
            head = node;
        }
        inOrder(node.right);
    }
}
