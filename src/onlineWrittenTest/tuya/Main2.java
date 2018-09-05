package onlineWrittenTest.tuya;


/**
 * @author Mr.Zhang
 * @create 2018-09-05 13:08
 */
public class Main2 {
    public static void main(String[] args) {
        int[] scores1 = {343,49,2};
        int[] scores2 = {3599,610,3};
        int[] scores3 = {62,36,7};

        System.out.println(score_of_winner(scores1));
        System.out.println(score_of_winner(scores2));
        System.out.println(score_of_winner(scores3));
    }

    /**
     * 依次用后一个数去挑战前面的结果
     * @param scores
     * @return
     */
    public static int score_of_winner(int[] scores){
        int realWinnerScore = 0;
        for (int i = 1; i < scores.length; i++) {
            realWinnerScore = scores[i]= winnerInTwo(scores[i-1],scores[i]);
        }
        return realWinnerScore;
    }

    /**
     * 从简单往困难分析
     * （1）如果两位选手所报出的分数都小于100，并且分数不同，则低分选手必然挑战失败（题中已经明确输入的是各不相等的正整数）
     *
     * （2）题中指出，如果挑战者计算错误，即《低分选手》所报分数不能分解成100以内数字的乘积，
     *        低分选手挑战失败
     *
     * （3）如果两名选手所报的分数，将分数分解成质因子相乘的形式，
     *      如果两个分数同时除去公共质因子
     *      若低分依旧大于100，
     *      若低分小于100，高分大于100
     *      若高分小于100，
     *
     *
     * @param score1
     * @param score2
     * @return
     */
    public static int winnerInTwo(int score1,int score2){
        if (score1 <= 100 && score2 <= 100){
            return score1;
        }
        if (score2 > 100){
            if (hasWrongInCount(score2)){
                return score1;
            }
        }
        if (maxPriem(score1) == maxPriem(score2)){
            int score1tmp = score1/maxPriem(score1);
            int score2tmp = score2/maxPriem(score2);
            if (score1tmp < 100 && score2tmp < 100){
                return score2;
            }else if (score1tmp > 100 && score2tmp < 100){
                return score1;
            }else if (score1tmp >100 && score2tmp>100){
                return winnerInTwo(score1tmp,score2tmp);
            }
        }

        return score2;
    }

    /**
     * 判断一个数能否分解成100以内不同数字的乘积
     * （1）如果该数的最大质因子大于100，则不能分解
     *
     * （2）该数在分解的过程中存在多个相同的质因子,
     *      例如（121 = 11*11；625 = 5*5*5*5=25*25 如何分解都不能满足要求）
     *
     * （3）
     * @param score
     * @return
     */
    public static boolean hasWrongInCount(int score){
        int prime = maxPriem(score);
        if (prime > 100){
            return false;
        }else return true;
    }

    /**
     * 求解一个数的最大质因子
     * @param num
     * @return
     */
    public static int maxPriem(int num){
        int prime = 0;
        int i = 2;
        while (num > 2){
            if (num % i == 0){
                prime = i;
                num /= i;
            }else i++;
        }
        return prime;
    }
}
