package jianzhioffer2;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		System.out.println(Fibonacci(5));
	}

	public static int Fibonacci(int n) {
        int indexOf0 = 1;
        int indexOf1 = 1;
        int result =0;
        while(n>2){
            result = indexOf0 + indexOf1;
            indexOf0 = indexOf1;
            indexOf1 = result;
            n--;
        }
        return result;
    }
}
