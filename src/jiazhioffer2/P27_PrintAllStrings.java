package jiazhioffer2;

import com.sun.javafx.tk.PermissionHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
* 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
*
* 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
* */
public class P27_PrintAllStrings {
    public static void main(String[] args) {
        P27_PrintAllStrings p27_printAllStrings = new P27_PrintAllStrings();
        ArrayList<String> strings = new ArrayList<String>();
        String str = "abc";
        strings = p27_printAllStrings.Permutation(str);
        System.out.println(strings.toString());
    }

    //先做排序，排序之后再进行排列组合

    //先排列，将排列后的字符串进行字典排序
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> stringArrayList = new ArrayList<String>();
        if(str != null&& str.length()>0){
            PremutationHelper(str.toCharArray(),0,stringArrayList);
            Collections.sort(stringArrayList);
        }
        return stringArrayList;
    }

    //使用递归实现全排列
    public void PremutationHelper(char[] chars,int i,List<String> list){
        if(i == chars.length){
            String val = String.valueOf(chars);
            if(!list.contains(val)){
                list.add(val);
            }
        }else {
            for (int j = i; j <chars.length ; j++) {
                //将当前值与之后的每一个都进行一次交换
                swap(chars,i,j);
                PremutationHelper(chars,i+1,list);

                //保证程序发生交换之后，恢复到交换之前的状态
                //递归，程序退栈
                swap(chars,i,j);
            }
        }
    }

    public void swap(char[] chars,int i,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
