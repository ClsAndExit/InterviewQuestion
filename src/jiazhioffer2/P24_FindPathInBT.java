package jiazhioffer2;

import java.util.ArrayList;

public class P24_FindPathInBT {
    public  static ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    public  static ArrayList<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) {

    }
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null)
            return listAll;
        list.add(root.val);
        target-=root.val;
        if(target==0&&root.left==null&&root.right   ==null){
            listAll.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return listAll;
    }
}