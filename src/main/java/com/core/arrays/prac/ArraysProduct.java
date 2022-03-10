package com.core.arrays.prac;

import java.util.stream.IntStream;

public class ArraysProduct {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };

		int prod = IntStream.of(arr).reduce(1, (x, y) -> x * y);
		System.out.println(prod);
	}
}
