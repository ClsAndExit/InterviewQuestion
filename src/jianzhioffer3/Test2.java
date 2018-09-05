package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-05 19:44
 * 计算机中处理乘法的指令要比加法复杂的多， 因为在一些关键系统中我们常常会考虑如何尽可能减少乘法的运算。
 * 现在有如下的表达式
 * y= anxn+an-1xn-1 +…..+a1x +a0
 * 其中an, an-1, ….a1, a0是常数， 给一个x， 要求尽快算出y的值。请尝试写出这样的一个函数。
 */
public class Test2 {
    public static void main(String[] args) {

    }

    /**
     * 思路：
     * F0=an;
     * F1=anx+an-1
     * Fn=xF(n-1)+an-1
     *
     * @param a
     * @param n
     * @param x
     * @return
     */
    public static int sum(int [] a,int n,int x){
        int sum = a[n];
        for (int i = 0; i <= n; i++) {
            sum += x*sum + a[n-1];
        }
        return sum;
    }
}
