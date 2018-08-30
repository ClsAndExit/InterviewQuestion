package dataStructureInNowCoder;

public class KatelanNum {
    public static void main(String[] args) {
        double n = 4;
        System.out.println(katelan1(n));
    }

    /**
     * 利用公式1：阶乘方法实现
     * 利用公式2：C(n)=C(n-1)*((4*n-2)/(n+1));（计算过程中出现了差错，果断放弃）
     *          个人感觉这种方法根本不现实（可能是使用了int类型的数据）
     *          (果然是，换成double之后就全部能够正常输出了)
     *
     * @param n
     * @return
     */
    public static double katelan1(double n){
        double inzi = ((4*n-2)/(n+1));
        if (n == 1){
            return 1.0;
        }else {
            double katelan = katelan1(n-1)*inzi;
            return katelan;
        }
    }
    public static int katelan(int n){
        int katelan = jiechng(2*n)/(jiechng(n+1)*jiechng(n));
        return katelan;
    }

    public static int jiechng(int n){
        if (n == 1){
            return 1;
        }else {
            int jiecheng = n * jiechng(n - 1);
            return jiecheng;
        }
    }
}
