package onlineWrittenTest.zhaoshang;

import java.util.Scanner;

/**
 * @author Mr.Zhang
 * @create 2018-09-16 19:54
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int sunm = 0;
        for (int i = 0; i <= n; i++) {
            if (ifWhile(i)) {
                sunm++;
            }
        }
        return sunm;
    }

    public static boolean ifWhile(int n) {
        int number = n;
        int daoxu = 0;
        int zhengxu = 0;
        int weishu = 0;
        while (number != 0) {
            int temp = number % 10;
            number /= 10;
            weishu++;
            if (temp == 2 || temp == 6)
                temp += 3;
            else if (temp == 5 || temp == 9)
                temp -= 3;
            else if (temp == 0 || temp == 1 || temp == 8)
                temp = temp;
            else
                return false;
            daoxu = daoxu * 10 + temp;
        }
        while (weishu != 0) {
            zhengxu = zhengxu * 10 + daoxu % 10;
            daoxu = daoxu / 10;
            weishu--;
        }
        if (zhengxu != n) {
            return true;
        } else
            return false;
    }
}
