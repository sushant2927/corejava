package com.core.java8.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseListJava8 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(5, 6, 4, 3, 2, 2, 1, 2, 4, 67, 8);

		//list.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
		
		list.stream().sorted().forEach(System.out::println);
		
		
		List<Integer> list1= list.stream().distinct().collect(Collectors.toList());
		
		list.stream().sorted((p1,p2)->p2-p1).forEach(System.out::println);	
		System.out.println(list1);
		
		Integer arr[] = { 1, 2, 3, 1, 4, 2, 3 };
		
		System.out.println("abc".hashCode());
		System.out.println("abb".hashCode());
	}

}
