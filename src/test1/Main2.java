package test1;

import com.sun.deploy.util.SyncAccess;



/**
 * @author Mr.Zhang
 * @create 2018-09-13 16:35
 */
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }

        int[] arr = solution(array);
        System.out.print(arr[0]);//获利最大值
        System.out.print(' ');
        System.out.print(arr[1]);//交易次数
    }

    public static int[] solution(int[] array) {
        int[] result = new int[2];
        int max = 0;
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                max += array[i + 1] - array[i];
                count += 2;
            }
        }
        result[0] = max;
        result[1] = count;
        return result;
    }
}
