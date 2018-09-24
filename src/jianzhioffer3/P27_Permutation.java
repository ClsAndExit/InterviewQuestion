package jianzhioffer3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author Mr.Zhang
 * @create 2018-09-24 10:24
 */
public class P27_Permutation {
    public static void main(String[] args) {
        String s = "abc";
        ArrayList<String> ss = Permutation(s);
        for (int i = 0; i < ss.size(); i++) {
            System.out.println(ss.get(i));
        }
    }

    /**
     * 回溯法
     * @param str
     * @return
     */
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str != null && str.length() > 0){
            PermutationHelper(str.toCharArray(),0,list);
            Collections.sort(list);
        }
        return list;
    }

    /**
     *
     * @param chars
     * @param i
     * @param list
     */
    public static void PermutationHelper(char[] chars,int i,ArrayList<String> list){
        if (i == chars.length -1){
            String val = String.valueOf(chars);
            if(!list.contains(val)){
                list.add(val);
            }
        }else {
            for (int j = i; j < chars.length ; j++) {
                swap(chars,i,j);
                PermutationHelper(chars,i+1,list);
                swap(chars,i,j);
            }
        }
    }

    public static void swap(char[] chars,int i,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
