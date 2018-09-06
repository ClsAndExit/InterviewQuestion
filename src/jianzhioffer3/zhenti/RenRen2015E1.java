package jianzhioffer3.zhenti;

import jianzhioffer3.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Mr.Zhang
 * @create 2018-09-06 14:44
 * 题目描述
 * 有如下图所示(左)的一棵二叉树， 请设计一种遍历方式，使得按照如下方式（右）输出各个元素：
 * （从下到上， 从右到左输出， 要求每层之间换行， 同行元素之间用tab分割，写出完整代码）。
 *
 */
public class RenRen2015E1 {
    public static void main(String[] args) {
        //手动构建二叉树
        //      1
        //  2       3
        // 4 5       6
        //（从下到上， 从右到左输出， 要求每层之间换行， 同行元素之间用tab分割，）
        // 4    5    6
        // 2    3
        // 1
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

        print(root);
    }

    /**
     * 逆序BFS搜索
     * 层次遍历
     * ArrayList存储每一层
     * ArrayListArrayList存储所有层
     * 倒序输出
     * @param root
     */
    public static void print(TreeNode root){
        if (root == null){
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Character>> arrayLists = new ArrayList<ArrayList<Character>>();
        queue.offer(root);
        int length = 1;
        while (!queue.isEmpty()){
            ArrayList<Character> nodes = new ArrayList<Character>();
            while (length != 0){
                TreeNode node = queue.pop();
                System.out.print(node.val+",");
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                nodes.add((char)(node.val+48));
                nodes.add('\t');
                length--;
            }
            //每行中最后一个\t不要
            nodes.remove(nodes.size()-1);
            nodes.add('\n');
            arrayLists.add(nodes);
            length = queue.size();
        }
        for (int i = arrayLists.size()-1; i >=0 ; i--) {
            ArrayList<Character> nodes = arrayLists.get(i);
            for (int j = 0; j < nodes.size(); j++) {
                System.out.print(nodes.get(j));
            }
        }
    }
}
