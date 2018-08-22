package jiazhioffer2;

/**
 * @Author Zhang
 * @Date 2018/8/21 10:14
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class P54_FirstAppearingOnce {
    public static void main(String[] args) {
        P54_FirstAppearingOnce hhh = new P54_FirstAppearingOnce();
        hhh.Insert('g');
        hhh.Insert('o');
        hhh.Insert('o');
        hhh.Insert('g');
        hhh.Insert('2');
        hhh.Insert('e');
        System.out.println(hhh.FirstAppearingOnce());
    }

    char[] hash = new char[256];
    String s = "";
    //Insert one char from stringstream
    public void Insert(char ch){
        hash[ch]++;
        s+=ch;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i)] == 1){
                return s.charAt(i);
            }
        }
        return '#';
    }
}
