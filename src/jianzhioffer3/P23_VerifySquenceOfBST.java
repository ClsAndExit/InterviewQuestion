package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-09 10:01
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class P23_VerifySquenceOfBST {
    public static void main(String[] args) {
        int[] sequence = {2,4,3,6,8,5,7};
        System.out.println(VerifySquenceOfBST1(sequence));
    }

    /**
     * 方法二：非递归实现
     * sequence[size]记录的是序列的最后一个元素，也就是根节点
     * 在比较的过程中... ...
     * @param sequence
     * @return
     */
    public static boolean VerifySquenceOfBST1(int[] sequence) {
        int size = sequence.length;
        if (size == 0)
            return false;
        int i = 0;

        //当根节点移除之后，序列中的最后一个结点是右子树的根节点
        //序列中剩余的元素排列顺序为  ：原根节点的右子树   当前节点的右子树   当前节点的左子树；
        //  由此可见也可以满足规则
        //依次类推，整个右子树都符合设想
        //当到达左子树的时候就更加容易理解了，因为整个原根节点的右子树已经不在序列的考虑范围之内了
        //只需要经左子树当作一颗新的BST即可
        while (size-- > 0) {
            //i从0开始，可将i看作是不能回退的索引
            //当i走完左子树的时候将会跳出次循环，然后进入下面的循环
            while (sequence[i] < sequence[size]){
                i++;
            }

            //这个循环是走右子树的
            while (sequence[i] > sequence[size]){
                i++;
            }

            //因为只有在整个左子树中没有大于根节点的值
            //在整个右子树中没有小于根节点的值
            //最后i的值才能达到左右子树中结点个数之和
            //否则返回false
            if (i<size)
                return false;
            i=0;
        }
        return true;
    }

    /**
     * 方法一：
     * 后序遍历的最后一个元素为根节点，通过比较大小可以将序列分成左右子树
     * 然后进行递归操作即可
     *
     * @param sequence
     * @return
     */
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0)
            return false;
        if (sequence.length == 1)
            return true;
        else
            return fuzhu(sequence, 0, sequence.length - 1);
    }

    public static boolean fuzhu(int[] array, int begin, int end) {
        if (begin >= end)
            return true;
        int root = array[end];
        int index = end;
        while (index > begin && array[index - 1] > root) {
            //找到左子树开始的下标
            index--;
        }
        for (int i = begin; i < index - 1; i++) {
            //如果左子树中有元素大于根节点，则直接返回false
            if (array[i] > root) {
                return false;
            }
        }
        return fuzhu(array, begin, index - 1) && fuzhu(array, index, end - 1);
    }
}
