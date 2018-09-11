package onlineWrittenTest.renren2017;



/**
 * @author Mr.Zhang
 * @create 2018-09-11 15:07
 */
import java.util.Arrays;
import java.util.Scanner;
public class MaxK {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int [] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        System.out.println(MaxkOFarray(array,k));
    }

    public static int MaxkOFarray(int[] array,int k){
        Arrays.sort(array);

        return array[array.length-k];
    }
}
