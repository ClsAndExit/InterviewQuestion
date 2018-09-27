package dataStructureInNowCoder.jichugainian;

/**
 * @author Mr.Zhang
 * @create 2018-09-26 16:12
 */
public class Myclass {
    public static void main(String[] args) {
        String s = "xxxxxxxxxxxxx#123#456#zzzzzzz";
        int n = s.indexOf("#");
        System.out.println(n);
        int k = s.indexOf("#",n+1);
        System.out.println(k);
        String s2 = s.substring(n+2,k);
        System.out.println(s2);
    }
}
