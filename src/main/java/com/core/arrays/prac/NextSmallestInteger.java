package com.core.arrays.prac;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class NextSmallestInteger {

	public static void main(String[] args) {
		Integer arr[] = { 1, 5, 7, 9 };
		List<Integer> list = Arrays.asList(arr);

		Function<List<Integer>, Integer> fn = l -> {

			int n = list.size();
			for (int i = 0; i < n; i++) {

				while (arr[i] >= 1 && arr[i] <= n && arr[i] != arr[arr[i] - 1]) {

					int temp = arr[arr[i] - 1];
					arr[arr[i] - 1] = arr[i];
					arr[i] = temp;
				}
			}

			for (int i = 0; i < n; i++)
				if (arr[i] != i + 1)
					return (i + 1);

			return (n + 1);

		};

		System.out.println(fn.apply(list));
	}

}
