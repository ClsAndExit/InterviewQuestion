package interviewExperience;

import java.util.Arrays;

/**
 * @author Mr.Zhang
 * @create 2018-09-04 10:49
 */
public class Permutations {
    public static void main(String[] args) {
      //  Combination1();

        String str= "321";
      //  Combination0(str.toCharArray(),new String(),0);
       // prem(str.toCharArray(),0,str.length()-1);
//        int count =1;
//        for (int i = 1; i <= str.length(); i++) {
//            count *= i;
//        }
//        char[] chars = str.toCharArray();
//        Arrays.sort(chars);//得到升序序列
//        for (int i = 0; i < count; i++) {
//            System.out.println(chars);
//            chars = permInOrder(chars);
//        }
//        cs = str.toCharArray();
//        rePerm(str.toCharArray(),0);
        String result = "";
        pernutation(str,result, str.length());
    }

    /**
     * 递归树实现全排列
     * 参考文章：https://www.cnblogs.com/lifegoesonitself/p/3225803.html
     * @param str
     * @param result
     * @param len
     */
    public static void pernutation(String str,String result,int len){
        if (result.length() == len){
            //一个全排列的结果
            System.out.println(result);
        }else {
            for (int i = 0; i < str.length(); i++) {
                //返回指定字符在此字符串中第一次出现处的索引
                //如果在result中不存在该字符，则进一步递归，并将该字符加上
                if (result.indexOf(str.charAt(i))<0){
                    pernutation(str,result+str.charAt(i),len);
                }
            }
        }
    }

    /**
     * 放回全排列:3*3*3
     * @param str
     * @param pos
     */
    public static char[] cs;
    public static void rePerm(char[] str,int pos){
        if (pos == str.length-1){
            for (int i = 0; i < str.length; i++) {
                str[pos] = cs[i];
                System.out.println(str);
            }
            return;
        }
        for (int i = 0; i < str.length; i++) {
            str[pos] = cs[i];
            rePerm(str,pos+1);
        }
    }

    /**
     * 按照从小到大的字典顺序进行排列
     * （1）首先需要将待处理字符串转化成字典排序序列“321”转化成“123”
     * 这里重点是找到某个顺序值得下一个顺序。
     * 找下一个顺序的算法如下：假设到了”21543“，从后往前找到i-1位置小于i位置的下标，1<5,
     * 所以要找的下表pos=1，将下标为1的数字1,和它后面最小的且大于它的数替换（3），
     * ”21543”--->"23541",然后再将下标1后面的字符串翻转得到："23145"，
     * 这就得到了“21543”下一个顺序值“23145”，如此下去，直到输出所有结果。
     * @param str
     * @return
     */
    public static char[] permInOrder(char[] str){
        for (int i = str.length-1;i>0; i--) {
            if (str[i] > str[i-1]){
                int loc = i;
                for (int j = i; j <str.length ; j++) {
                    if(str[j] < str[loc] && str[j] > str[i-1]){
                        loc = j;
                    }
                }
                swap(str,i-1,loc);
                reverse(str,i,str.length-1);
                return str;
            }
        }
        return str;
    }

    public static void reverse(char[] str,int from,int to){
        while (from < to){
            swap(str,from,to);
            from ++;
            to --;
        }
    }
    /**
     * 从字符串中选择一个作为第一个字符，然后对剩下的字符串进行全排列，如此递归下去，直到打印出全部排列。
     * @param chars
     * @param a
     * @param b
     */
    public static void swap(char[] chars,int a,int b){
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
    public static void prem(char[] str,int from,int to){
        if (from == to){
            System.out.println(str);
            return;
        }
        for (int i = from; i <= to ; i++) {
            swap(str,from,i);
            prem(str,from+1,to);
            swap(str,from,i);
        }
    }

    /**
     * 思路：
     *这种组合的方法思路还没有理清
     * @param src
     * @param str
     * @param pos
     */
    public static void Combination0(char[] src,String str,int pos){
        if (pos == src.length){
            if (!str.isEmpty()){
                System.out.println(str);
            }
            return;
        }
        Combination0(src,str,pos+1);
        Combination0(src,str+src[pos],pos+1);
    }

    /**
     * 求全组合基本思路：
     * 假设原有元素n个，则最终组合结果是2^n个，因为每一位上面的值可能出现可能不出现
     * 根据上面的原理，可以使用位图（byte map）作为标记，进行输出
     *
     * 缺点：限制了待处理数组的长度，不能超过int / long类型数据的位数
     */
    public static void Combination1(){
        String[]strs = {"a","b","c"};
        int n = strs.length;
        int nbit = 1<<n;
        System.out.println("全组合结果个数为"+nbit);
        for (int i = 0; i < nbit; i++) {
            System.out.println("组合数值"+i+"对应的编码为：");
            for (int j = 0; j < n; j++) {
                int tmp = 1<<j;
                if ((tmp & i) != 0){
                    System.out.print (strs[j]+",");
                }
            }
            System.out.println();
        }
    }
}












