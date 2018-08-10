package jiazhioffer2;

import java.util.ArrayList;

public class P22_PrintFromTopToBottom {
    public static void main(String[] args) {
        //构建二叉树
        //      1
        //  2       3
        // 4 5       6
        //
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.right = node5;
        System.out.println(PrintFromTopToBottom(root).toString());
    }
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<TreeNode> queue= new ArrayList<TreeNode>();

        if(root == null){
            return null;
        }
        queue.add(root);

        while (!queue.isEmpty()){
            //队列头元素
            TreeNode temp =queue.remove(0);
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
            arrayList.add(temp.val);
        }

        return arrayList;
    }
}
