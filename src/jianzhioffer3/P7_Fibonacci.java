package jianzhioffer3;

/**
 * @author Mr.Zhang
 * @create 2018-09-02 15:46
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class P7_Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(Fibonacci(n));
        System.out.println(Fibonacci1(n));
    }

    /**
     * 方法一：递归实现
     * 方法二：非递归实现
     * @param n
     * @return
     */
    public static  int Fibonacci(int n){
        int fibonacci = 0;
        if (n ==0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 1;
        }
        fibonacci += Fibonacci(n-1)+Fibonacci(n-2);
        return fibonacci;
    }

    public static int Fibonacci1(int n){
        if (n ==0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 1;
        }
        int pre = 1;
        int prepre = 1;
        int fibonacci = 0;
        while (n > 2){
            fibonacci = pre+prepre;
            prepre = pre;
            pre = fibonacci;
            n--;
        }
        return fibonacci;
    }
}
