package jianzhioffer3.zhenti;


/**
 * @author Mr.Zhang
 * @create 2018-09-06 14:44
 * 题目描述
 * 某星球上出现了一种怪物， 这种怪物是《单亲》繁殖，
 * 从出生起第3个月起每个月就能繁衍一批后代共m个，但是这种怪物很短命，生存第5个月后就会毙命。
 * 目前该星球有一个这样的怪物，
 * 请编写程序计算n个月后怪物的总数。(这里我们假定第5个月怪物繁衍后再毙命)
 *
 */
public class RenRen2015E2 {
    public static void main(String[] args) {
        int n = 13;//length of month
        int m = 4;//number of baby
        System.out.println(sum(n,m));
    }
    //定义一个长度为n的数组，用来存储0~n每个月的种群数量
    public static int sum(int n,int m){
        int res = 1;
        int[] array = new int[n];
        if (n<3){
            return res;
        }
        array[0] = 1;
        array[1] = 0;
        array[2] = 0;
        for (int i = 3; i <n; i++) {
            //i-1 and i-1时候出生的还不能繁殖
            array[i] = (res - array[i-1]-array[i-2])*m;
            //当前的总数量
            res+=array[i];
            if (i>=5)
                //5个月前的那一批全都毙命
                res -=array[i-5];
        }
        return res;
    }
}
