package jiazhioffer2;

import java_threadPool.DefaultThreadPool;
import sun.security.krb5.internal.crypto.Des;

import java.net.ServerSocket;

/**
 * @Author Zhang
 * @Date 2018/8/23 10:05
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class P61_SerializeOfBinaryTree   {
    public static void main(String[] args) {
        //构建二叉树
        //      1
        //  2       3
        // 4 5       6
        //
        //      1,2,4,#,#,5,#,#,3,#,6,#,#,
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

        P61_SerializeOfBinaryTree p61_serializeOfBinaryTree = new P61_SerializeOfBinaryTree();
        //序列化
//        String serialize  = p61_serializeOfBinaryTree.Serialize(root);
//        p61_serializeOfBinaryTree.print(root);
//        System.out.println();
//        System.out.println(serialize);

        //反序列化
        TreeNode proot = p61_serializeOfBinaryTree.Deserialize("1,2,4,#,#,5,#,#,3,#,6,#,#,");
        p61_serializeOfBinaryTree.print(proot);
    }

    String Serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        if (root == null){
            stringBuilder.append("#,");
            return stringBuilder.toString();
        }
        stringBuilder.append(root.val+",");
        stringBuilder.append(Serialize(root.left));
        stringBuilder.append(Serialize(root.right));
        return stringBuilder.toString();
    }
    //定义变量，标记字符串下标
    int index =-1;
    TreeNode Deserialize(String str) {
        index++;
        int length = str.length();
        if(index > length){
            return null;
        }
        String [] strs = str.split(",");
        TreeNode node = null;
        if(!strs[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strs[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }

        return node;
    }

    void print (TreeNode root){
        System.out.print(root.val+",");
        if (root.left != null ){
            print(root.left);
        }
        if (root.right!= null){
            print(root.right);
        }
    }
}
