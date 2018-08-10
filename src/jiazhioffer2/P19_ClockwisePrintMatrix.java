package jiazhioffer2;

import java.util.ArrayList;

public class P19_ClockwisePrintMatrix {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		pring(1, printMatrix(matrix));
	}

	public static ArrayList<Integer> printMatrix(int[][] matrix) {

		ArrayList<Integer> arrayList = new ArrayList<>();
		int r = matrix.length;
		int c = matrix[0].length;
		int total = r * c;
		int right_r = r;
		int right_c = c;
		int left_r = 0, left_c = 0;
		int i = 0, j = 0;
		
		while(total > 0) {
			//从左到右打印
			while(total>0&&j<right_c) {
				total--;
				arrayList.add(matrix[i][j]);
				j++;
			}
			j--;
			i++;
			//从上到下打印
			while (total>0&&i<right_r-1) {
				total --;
				arrayList.add(matrix[i][j]);
				i++;
			}
			
			//从右到左打印
			while (total>0&&j>=left_c) {
				total--;
				arrayList.add(matrix[i][j]);
				j--;
			}
			j++;
			i--;
			
			//从下到上打印
			while (total>0&&i>left_r) {
				total--;
				arrayList.add(matrix[i][j]);
				i--;
			}
			i++;
			j++;
			left_c++;
			left_r++;
			right_c--;
			right_r--;
			
		}
		
		return arrayList;
	}

	public static void pring(int index, Object object) {
		System.out.println(String.format("%d,%s", index, object.toString()));
	}
}
