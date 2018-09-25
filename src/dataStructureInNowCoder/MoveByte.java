package dataStructureInNowCoder;

/**
 * @author Mr.Zhang
 * @create 2018-09-25 14:23
 */
public class MoveByte {
    public static void main(String[] args) {
        int num = 7;//-7
        printInfo(num);
        int num1 = num >> 1;
        printInfo(num1);
        int num2 = num << 1;
        printInfo(num2);
        int num3 = num >>> 1;
        printInfo(num3);

        int num4 = num << 2;
        printInfo(num4);
        int num41 = num >> 2;
        printInfo(num41);
        int num5 = num >>> 2;
        printInfo(num5);
    }

    public static void printInfo(int num){
        System.out.println(num+":"+Integer.toBinaryString(num));
    }
}
