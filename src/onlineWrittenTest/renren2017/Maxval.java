package onlineWrittenTest.renren2017;



/**
 * @author Mr.Zhang
 * @create 2018-09-11 15:16
 */
import java.util.Scanner;
public class Maxval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(maValue(n,k));
    }

    public static int maValue(int n,int k){
        String binaryStr = java.lang.Integer.toBinaryString(n);
        int len = binaryStr.length();
        int max = 0;
        if (len >= k){
            k--;
            len--;
            while (k >= 0){
                max += Math.pow(2,len);
                len--;
                k--;
            }
        }

        return max;
    }
}
