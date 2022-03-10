package com.core.java.prac;

public class ArrayFindAllMissingNumber {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 6, 7, 8, 9 };
		int N = arr.length;

		int diff = arr[0] - 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] - i != diff) {

				while (diff < arr[i] - i) {
					System.out.println(i + diff + " ");
					diff++;
				}
			}

		}
	}
}
