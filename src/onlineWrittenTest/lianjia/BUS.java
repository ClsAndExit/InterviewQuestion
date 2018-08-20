package onlineWrittenTest.lianjia;

import java.util.Scanner;

/**
 * @Author Zhang
 * @Date 2018/8/18 14:53
 */
public class BUS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxOfPeople = 0;
        int countOfPeople = 0;
        int theNumberOFStation = scanner.nextInt();
        //下车
        int [] arraya = new int[theNumberOFStation];
        //上车
        int [] arrayb = new int[theNumberOFStation];
        for (int i = 0; i < theNumberOFStation; i++) {
            arraya[i] = scanner.nextInt();
            arrayb[i] = scanner.nextInt();
            maxOfPeople=Math.max(maxOfPeople,countOfPeople+(arrayb[i] - arraya[i]));
            countOfPeople = countOfPeople+(arrayb[i] - arraya[i]);
        }
        System.out.println(maxOfPeople);
    }
}
