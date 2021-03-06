package jianzhioffer2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author Zhang
 * @Date 2018/8/16 10:31
 *
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 1,2,3,4,5,6,8,9
 */
public class P33_GetUglyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int index = scanner.nextInt();
        System.out.println(getUglyNumber(index));
    }

    public static int getUglyNumber(int index){
        if (index <= 0)
            return 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int item2 =0,item3 =0,item5 = 0;
        list.add(1);
        while (list.size()<index){
            int min2 = list.get(item2)*2;
            int min3 = list.get(item3)*3;
            int min5 = list.get(item5)*5;
            int min = Math.min(min2,Math.min(min3,min5));
            list.add(min);
            if (min == min2)
                item2++;
            if (min == min3)
                item3++;
            if (min == min5)
                item5++;
        }
        return list.get(list.size()-1);
    }
}
