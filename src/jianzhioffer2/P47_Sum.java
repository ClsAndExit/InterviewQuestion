package jianzhioffer2;

/**
 * @Author Zhang
 * @Date 2018/8/18 20:32
 */
public class P47_Sum {
    public static void main(String[] args) {
        System.out.println(sum(10));
    }

    /**
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * @param n
     * @return
     */
    public static int sum(int n){
        int ans = n;
        boolean flag = (ans>0) &&((ans += sum(n-1))>0);
        return ans;
    }
}
