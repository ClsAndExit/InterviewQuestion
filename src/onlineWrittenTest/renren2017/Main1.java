package onlineWrittenTest.renren2017;

import java.util.Scanner;

/**
 * @author Mr.Zhang
 * @create 2018-09-04 9:22
 *
 * 小明正在做物理实验，他在示波器上观察波形。在每一时刻，他能观察到两种可能的波形，一种是水平波形，由两个下划线组成：__。一种是脉冲波形，由一个斜杠和一个反斜杠组成：/\。
 *
 * 小明观察到一个水平波形就在数据表上记录一个减号-，观察到一个脉冲波形就在数据表上记录一个加号+。如小明观察到波形__/\__/\/\__，他就会记录-+-++-。
 *
 * 现在小明想实现纪录序列与波形之间的转化，你能帮助他吗？
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while (input != "#"){
            input = scanner.next();
            if (input.charAt(0) == '-' || input.charAt(0) == '+'){
                for (int i = 0; i < input.length(); i++) {
                    System.out.println(input.charAt(i) == '-' ? "__":"/\\");
                }
            }
            if (input.charAt(0) == '_' || input.charAt(0) == '/'){
                for (int i = 0; i < input.length(); i=i+2) {
                    System.out.println(input.charAt(i) == '_' ? '-' :'+');
                }
            }
        }
    }
}
