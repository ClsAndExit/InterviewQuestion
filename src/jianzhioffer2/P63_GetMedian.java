package jianzhioffer2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author Zhang
 * @Date 2018/8/23 15:39
 *
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值《排序之后》位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值《排序之后》中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class P63_GetMedian {
    public static void main(String[] args) {
        P63_GetMedian p63_getMedian = new P63_GetMedian();
        for (int i = 0; i < 3; i++) {
            p63_getMedian.Insert(i);
        }
        System.out.println(p63_getMedian.GetMedian());
    }
    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    /**
     * 插入、排序、判断、取值
     * @param num
     */
    public void Insert(Integer num) {
        arrayList.add(num);
    }

    public Double GetMedian() {
        int lenth = arrayList.size();
        Collections.sort(arrayList);
        if (lenth % 2 == 1){
            return (double)arrayList.get(lenth/2);
        }else {
            double num1 = (double)arrayList.get(lenth/2);
            double num2 = (double)arrayList.get(lenth/2-1);
            return (num1+num2)/2;
        }
    }

    /**
     * 提高效率的做法：
     * 使用大小堆
     * 第二刷时候再加入吧。。。。。
     */
}
