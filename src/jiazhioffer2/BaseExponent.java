package jiazhioffer2;

import java.util.Iterator;

public class BaseExponent {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		System.out.println(Power(2, -3));
		System.out.println(Math.pow(0, 0));
	}

	public static double Power(double base, int exponent) {
		double result = base;
		if (base == 0) {
			result = 0;
			return result;
		}
		if (exponent == 0) {
			result = 1;
			return result;
		}

		if(exponent > 0) {
			for(int i =0;i<exponent-1 ;i++) {
				result *=base;
			}
		}
		if(exponent < 0) {
			for(int i =0;i>exponent+1 ;i--) {
				result *=base;
			}
			result = 1/result;
		}
		return result;
	}
}
