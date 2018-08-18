package jiazhioffer2;

/**
 * @Author Zhang
 * @Date 2018/8/17 21:05
 *
 * 题目描述
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class P44_ReverseSentence {
    public static void main(String[] args) {
        String string =" ";
        String str = ReverseSentence(string);
        System.out.println(" ");
        System.out.println(str);
    }

    public static String ReverseSentence (String str){
        if (str.length() == 1){
            return str;
        }
        String[] strings = str.split(" ");
        flip(strings,0,strings.length-1);
        String tmpStr ="";
        for (int i = 0; i < strings.length; i++) {
            if (i!=strings.length-1)
                tmpStr+=strings[i]+" ";
            else
                tmpStr+=strings[i];

        }
        return tmpStr;
    }

    public static void flip(String[] array,int i,int j){
        while (i<j){
            String tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;

            i++;
            j--;
        }
    }
}
