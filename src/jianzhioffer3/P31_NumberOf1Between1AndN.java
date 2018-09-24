package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-24 14:42\
 * 题目描述
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class P31_NumberOf1Between1AndN {
    public static void main(String[] args) {
        System.out.println(solution(23));
    }

    public static int solution(int n) {
        if (n < 1) {
            return 0;
        }
        int count = 0;//记录一共多少
        /**对于base的解释如下
         * 如果是个位,则当计算出的rount时。有rount个（0~9）出现，每出现一次是1个一
         * 如果是十位，则当计算出rount时，表示有rount个（10~19）出现，每次出现是10个一
         * 如果是百位，则当计算出rount时，表示有rount个（100~199）出现，每次出现是100个一
         */
        int base = 1;//位于不同基数位上面1出现的次数
        int round = n;//每次降低一个基数
        while (round > 0) {
            int weight = round % 10;//13 weight = 3
            round /= 10;//1
            //统计高位上面1的个数
            count += round * base;//1 个 0~9 每个0~9中有1个1

            //统计低位上面1的个数
            if (weight == 1) {
                count += (n % base) + 1; //例如13 weight= 3 则10 11 12 十位上面的1出现了3次，
                                        // 若是123 则百位上面的1出现23 次
            }
            if (weight > 1) {
                count += base;//1+1 = 2
            }
            base *= 10;
        }
        return count;
    }
}
