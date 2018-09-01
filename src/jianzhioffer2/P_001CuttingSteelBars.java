package jianzhioffer2;

/**
 *  * @author miracle
 *  *切割钢条问题：
 *  *长度：1	2	3	4	5	6	7	8	9	10
 *  *价格：1	5	8	9	10	17	17	20	24	30
 *  *问长度为n的钢条的最多卖多少钱
 */
public class P_001CuttingSteelBars {
    int[] prices = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
    int[] dp = new int[prices.length];
    public static void main(String[] args) {
        P_001CuttingSteelBars s= new P_001CuttingSteelBars();

        System.out.println(solution0(s.prices,1));
        System.out.println(solution0(s.prices,10));
//        System.out.println(solution1(prices,3));
//        System.out.println(solution1(prices,4));
//        System.out.println(solution2(prices,5));
//        System.out.println(solution2(prices,6));

    }

    public static int solution0(int [] prices,int n){
        if(n == 0) return 0;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            max = Math.max(max, prices[i] + solution0(prices, n - i));
        }
        return max;
    }
//    public static int solution1(int [] array,int n){
//
//    }
//    public static int solution2(int [] array,int n){
//
//    }
//public int solveWithMemoUpToBottom(int[] prices, int n){
//    if(n == 0 || dp[n] > 0) return dp[n];
//    int max = Integer.MIN_VALUE;
//    for(int i = 1; i <= n; i++){
//        max = Math.max(max, prices[i] + solve(prices, n - i));
//    }
//    dp[n] = max;
//    return max;
//}
//
//    public int solveBottomToUp(int[] prices, int n){
//        int[] dp = new int[prices.length];
//        for(int i = 1; i <= n; i++){
//            int max = Integer.MIN_VALUE;
//            for(int j = 1; j <= i; j++){
//                max = Math.max(max, prices[j] + prices[i - j]);
//            }
//            dp[i] = max;
//        }
//        return dp[n];
//    }

}
