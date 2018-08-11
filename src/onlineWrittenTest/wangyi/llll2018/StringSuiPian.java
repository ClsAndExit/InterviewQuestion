package onlineWrittenTest.wangyi.llll2018;

/**
 * 一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成的。
 * 例如,"aaabbaaac"是由下面碎片组成的:'aaa','bb','c'。牛牛现在给定一个字符串,
 * 请你帮助计算这个字符串的所有碎片的平均长度是多少。
 *
 * 所有碎片的平均长度等于字符串长度/字符串碎片的个数
 */
public class StringSuiPian {
    public static void main(String[] args) {
        String str = "aaabbaaac";
        int length = str.length();
        int sum =1;
        for (int i = 1; i < length; i++) {
            if(str.charAt(i)!=str.charAt(i-1)){
                sum++;
            }
        }
        System.out.println((double) length/sum);
    }
}
