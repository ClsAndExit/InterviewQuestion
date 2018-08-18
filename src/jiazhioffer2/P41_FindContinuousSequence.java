package jiazhioffer2;

import java.util.ArrayList;

/**
 * @Author Zhang
 * @Date 2018/8/17 16:36
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,
 * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class P41_FindContinuousSequence {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists = FindContinuousSequence(100);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j)+",");
            }
            System.out.println();
        }
    }

    /**
     * 方法一：
     *
     * @param sum
     * @return
     * 输出描述:
     * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum){
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();

        int begin =1;
        int end = 2;
        //停止条件是begin==end，此时的情况是begin和end同时都指向了sum本身，但是题目要求至少包括两个数
        while (begin<end){
            //计算当前序列的和（利用等差数列求和公式）
            int count = (begin+end)*(end-begin+1)/2;
            if (count == sum){
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i = begin; i <=end ; i++) {
                    list.add(i);
                }
                arrayLists.add(list);
                //已经得到了一个结果，然后将begin向后移动，继续向下寻找其他结果
                begin++;
            }else if (count < sum){
                end++;
            }else if (count > sum){
                begin++;
            }
        }
        return arrayLists;
    }

}
