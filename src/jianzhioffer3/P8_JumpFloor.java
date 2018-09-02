package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-02 15:57
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class P8_JumpFloor {
    public static void main(String[] args) {
        int target = 4;
        System.out.println(JumpFloor(target));
    }

    /**
     * 解题思路：
     * 有一个台阶的时候     1
     * 有两个台阶的时候     2
     * 有三个台阶的时候     1+2
     * 有四个台阶的时候     三个台阶+1个台阶/两个台阶+两个台阶 = 5
     * 有五个台阶的时候     四个台阶+1个台阶/三个台阶+两个台阶 = 5+3 = 8
     * 通过总结前面的规律可知f(n) = f(n-1)+f(n-2)也就是斐波那契数列的求解过程
     * @param target
     * @return
     */
    public static int JumpFloor(int target){
        if(target == 1){
            return  1;
        }
        if (target == 2){
            return 2;
        }
        int first = 1;
        int second = 2;
        int result = 0;
        while (target>2){
            result = first+second;
            first = second;
            second = result;
            target --;
        }
        return result;
    }
}
