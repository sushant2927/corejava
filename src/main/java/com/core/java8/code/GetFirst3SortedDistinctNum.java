package com.core.java8.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class GetFirst3SortedDistinctNum {

	public static void main(String[] args) {

		int arr[] = { 4, 4, 5, 8, 6, 7, 6, 5, 2, 0, 1,1,2 };

		IntStream.of(arr).distinct().sorted().limit(1).forEach(System.out::println);
		
		
		System.out.println("list in sorted and revered order");
		List<Integer> list=Arrays.stream(arr).boxed().toList();
		
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		System.out.println("list in sorted and natural order");
		
		list.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
		
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}

}
