package test1;

public class BinaryOfNegativeNumbers {
    public static void main(String[] args) {
        int number1 = -1;
        int number2 = 2147483647;

        String binaryStr1 = java.lang.Integer.toBinaryString(number1);
        System.out.println("the result is : " + binaryStr1);

        String binaryStr2 = java.lang.Integer.toBinaryString(number2);
        System.out.println("the result is : " + binaryStr2);


        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        System.out.println("int的最大值： " + max);	//01111111 11111111 11111111 11111111
        System.out.println("int的最大值+1： " + (max+1));		//11111111 11111111 11111111 11111111
        System.out.println("int的最小值： " + min);	//10000000 00000000 00000000 00000000
        System.out.println("int的最小值－1： " + (min-1));	//01111111 11111111 11111111 11111111

    }
}
