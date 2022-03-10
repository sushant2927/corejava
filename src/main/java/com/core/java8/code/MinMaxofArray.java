package com.core.java8.code;

import java.util.Arrays;
import java.util.List;

public class MinMaxofArray {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		Integer result = numbers.stream().mapToInt(v -> v).max().orElse(Integer.MAX_VALUE);

		System.out.println("Max " + result);

		Integer result2 = numbers.stream().mapToInt(v -> v).min().orElse(Integer.MAX_VALUE);

		System.out.println("Min " + result2);
	}
}