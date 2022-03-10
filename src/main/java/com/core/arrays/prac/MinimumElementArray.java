package com.core.arrays.prac;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinimumElementArray {

	public static void main(String[] args) {
		
		int arr[]= {9,6,3,7,4,5,8,6,4};
		
		int min=arr[0];
		for (int i = 0; i < arr.length; i++) {
			
			if (min>arr[i]) {
				
				min=arr[i];
			}
		}
		
		System.out.println(min);
		
		int min1=IntStream.of(arr).min().getAsInt();
		
		IntStream.of(arr).min().ifPresent(System.out::println);
		
		System.out.println(min1);
		
		List<Integer> list=Arrays.stream(arr).boxed().collect(Collectors.toList());
		
		Integer intMin= list.stream().collect(Collectors.minBy(Comparator.naturalOrder())).get();
		System.out.println(intMin);
		
		System.out.println("sort and reverse it");
		
		list.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
}
}
