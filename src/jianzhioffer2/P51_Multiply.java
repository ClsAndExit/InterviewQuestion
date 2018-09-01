package jianzhioffer2;

import java.util.Arrays;

/**
 * @Author Zhang
 * @Date 2018/8/20 10:55
 * 题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class P51_Multiply {
    public static void main(String[] args) {
        int [] A = {1,2,3,4,5,6};
        int [] B = multiply(A);
        System.out.println(Arrays.toString(B));
    }

    public static int[] multiply(int[] A){
        int [] b = new int[A.length];
        int n = A.length;
        int ret=1;
        for(int i=0;i<n;ret*=A[i++]){
            b[i]=ret;
        }
        ret=1;
        for(int i=n-1;i>=0;ret*=A[i--]){
            b[i]*=ret;
        }
        return b ;
    }
}
