package jianzhioffer2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author Zhang
 * @Date 2018/8/22 15:35
 *
 * 题目描述
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class P58_IsSymmetrical {
    public static void main(String[] args) {

    }

    /**
     * 方法一：递归
     * 方法二：使用栈或队列实现DFS  或 BFS
     * @param pRoot
     * @return
     */
    public static boolean isSymmetrical(TreeNode pRoot){
        if (pRoot == null){
            return true;
        }
        return equal(pRoot.left,pRoot.right);
    }
    public static boolean equal(TreeNode node1,TreeNode node2){
        if (node1==null && node2 == null )
            return true;
        if (node1!=null && node2 != null){
            return node1.val == node2.val&& equal(node1.left, node2.right)&& equal(node2.right,node1.left);
        }
        return false;
    }

    /**
     *
     * @param pRoot
     * @return
     */

    boolean isSymmetricalDFS(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        Stack<TreeNode> s = new Stack<>();
        s.push(pRoot.left);
        s.push(pRoot.right);
        while(!s.empty()) {
            TreeNode right = s.pop();//成对取出
            TreeNode left = s.pop();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            //成对插入
            s.push(left.left);
            s.push(right.right);
            s.push(left.right);
            s.push(right.left);
        }
        return true;
    }

    boolean isSymmetricalBFS(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        Queue<TreeNode> s = new LinkedList<>();
        s.offer(pRoot.left);
        s.offer(pRoot.right);
        while(!s.isEmpty()) {
            TreeNode right = s.poll();//成对取出
            TreeNode left = s.poll();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            //成对插入
            s.offer(left.left);
            s.offer(right.right);
            s.offer(left.right);
            s.offer(right.left);
        }
        return true;
    }


}
