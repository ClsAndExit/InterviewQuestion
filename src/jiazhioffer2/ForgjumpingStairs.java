package jiazhioffer2;

/**
 * 有错误，没解决
 * @author Admin
 *
 */
public class ForgjumpingStairs {

	public static void main(String[] args) {

		System.out.println(jumpFloor(6));
	}
	
	public  static int  jumpFloor(int number) {
		int num = 0;
		int ans = 0;
		while(number >num) {
			ans += cnm(number, num);
			num++;
			number--;
		}
		return ans;
	}

	public static int cnm(int x, int y) {
		y = y < (x - y) ? y : (x - y);

		int result = 1;
		int num = y;
		while (num-- > 0) {
			result *= x;
			x--;
		}
		for (int i = 2; i <= y; i++) {
			result /= i;

		}
		return result;
	}
}
