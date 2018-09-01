package jianzhioffer2;

/**
 * 1.首先最后一个节点是根节点，根据BST的定义，从左到右查找第一个到大于跟节点的节点;
 * 2.a.查找到那个节点后，首先判断它是不是就是根节点，如果是，说明右子树为空;接下去只需要递归验证左子树即可;
 *   b.若那个节点就是begin节点，说明左子树为空，那么只需要判断右子树即可。
 *   c.若有左右子树，继续验证剩下的节点是否每个都大于根节点，若不符合，直接返回false
 * 3.满足2c条件，递归判断左，右子树是否满足。
 *
 */
public class P23_VerifySquenceOfBST {
    public static void main(String[] args) {
        int []ar = {4,8,6,12,16,14,10};
        System.out.println(VerifySquenceOfBST(ar));
    }

    public static boolean VerifySquenceOfBST(int [] sequence) {

        if(sequence.length==0)
            return false;
        if(sequence.length==1)
            return true;

        return fuzhu(sequence,0,sequence.length-1);
    }

    public static boolean fuzhu(int[] array,int begin,int end){
        if(begin>=end){
            return true;
        }
        int i = end;
        while (i>begin&&array[i-1]>array[end])
            i--;
        for (int j = begin; j < i-1; j++) {
            if(array[j]>array[end]){
                return false;
            }
        }
        return fuzhu(array,begin,i-1)&&fuzhu(array,i,end-1);
    }
}
