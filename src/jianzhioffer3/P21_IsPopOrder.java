package jianzhioffer3;

import java.util.ArrayList;

/**
 * @author Mr.Zhang
 * @create 2018-09-08 20:18
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class P21_IsPopOrder {
    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 1, 2};
        System.out.println(IsPopOrder(push,pop));
    }

    /**
     * 模拟入栈出栈过程，可用栈，可用动态数组
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length != popA.length){
            return false;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int popIndex = 0;

        for (int i = 0; i < pushA.length; i++) {
            arrayList.add(pushA[i]);
            while (!arrayList.isEmpty() && arrayList.get(arrayList.size()-1) == popA[popIndex]){
                arrayList.remove(arrayList.size()-1);
                popIndex++;
            }
        }
        return arrayList.isEmpty();
    }
}
