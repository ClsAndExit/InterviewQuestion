package jiazhioffer2;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有
 * 1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 * 解析参考：https://blog.csdn.net/yi_afly/article/details/52012593
 *
 *
 */
public class P31_NumberOf1Between1AndN {
    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(123));
    }
    //
    public static int NumberOf1Between1AndN_Solution(int n) {
        if(n<1)
            return 0;
        int count = 0;
        /**对于base的解释如下
         * 如果是个位,则当计算出的rount时。有rount个（0~9）出现，每出现一次是1个一
         * 如果是十位，则当计算出rount时，表示有rount个（10~19）出现，每次出现是10个一
         * 如果是百位，则当计算出rount时，表示有rount个（100~199）出现，每次出现是100个一
         */
        int base = 1;
        int round = n;
        while (round>0){
            //统计当前位的后一位上面1的个数
            int weight = round % 10;
            round /= 10;
            count += round*base;
            //统计当前位上面1出现的次数
            if(weight == 1){
                //
                count+=(n%base)+1;
            }else if (weight>1){
                count+=base;
            }
            base *= 10;
        }
        return count;
    }

    public static int NumberOf1Between1AndN_Solution1(int n) {
        int count =0;
        for (int i = 0; i <= n; i++) {
            int tmp = i;
            while (tmp>0){
                if(tmp%10 == 1){
                    count++;
                }
                tmp /=10;
            }
        }
        return count;
    }
}
