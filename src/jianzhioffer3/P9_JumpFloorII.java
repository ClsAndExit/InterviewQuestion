package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-02 16:13
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class P9_JumpFloorII {
    public static void main(String[] args) {
        int target = 3;
        System.out.println(JumpFloorII(target));
    }

    /**
     * 解题思路：
     * 推理：f(n) = f(n-1)+f(n-2)+... ...+f(2)+(1)+1
     * f(n-1) = f(n-2)+... ...+f(2)+(1)+1
     * f(n) = 2f(n-1)
     * @param target
     * @return
     */
    public static int JumpFloorII(int target){
        if(target <= 0){
            return -1;
        }else if (target == 1){
            return 1;
        }else {
            return 2*JumpFloorII(target-1);
        }
    }
}
