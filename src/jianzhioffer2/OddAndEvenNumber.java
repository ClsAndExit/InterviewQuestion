package jianzhioffer2;

public class OddAndEvenNumber {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// reOrderArray(array);
		// swap(array, 2, 3);
		reOrder(array);
		// reOrderArray1(array);
		for (int i : array) {
			System.out.println(i);
		}
	}

	public static void reOrderArray1(int[] array) {
		/**
		 * 算法思路： 采用冒泡法思想，只要遇到前偶后奇则交换
		 */
		int temp;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * 利用冒泡排序的思想，只要是前偶数后奇数就交换
	 * 
	 * @param array
	 */
	public static void reOrder(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (!odd(array[j]) && odd(array[j + 1])) {
					swap(array, j, j + 1);
				}
			}
		}
	}

	public static void reOrderArray(int[] array) {
		int leftIndex = 0;
		int rightIndex = array.length - 1;
		while (leftIndex < rightIndex) {
			if (!odd(array[leftIndex]) && odd(array[rightIndex])) {
				swap(array, leftIndex, rightIndex);
			}
			if (odd(array[leftIndex])) {
				leftIndex++;
			}
			if (!odd(array[rightIndex])) {
				rightIndex--;
			}
		}
	}

	public static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	/**
	 * 是否为奇数
	 * 
	 * @param number
	 * @return
	 */
	public static boolean odd(int number) {
		if (number % 2 == 0) {
			return false;
		} else {
			return true;
		}
	}
}