package com.core.java8.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java8DemoPrac {

	public static void main(String[] args) throws Exception {

		//Integer arr[] = { 5, 1, 6, 3, 6, 7, 2, 1, 4, 3 };
		
		Integer arr[] = {8,3,5,1,6,7,1,3,6,7,8};

		List<Integer> numList = Arrays.asList(arr);
		System.out.println("Initial List");
		System.out.println(numList);

		// numList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

		// numList.stream().sorted().distinct().forEach(System.out::println);

		
		  Integer intVal = numList.stream().max(Comparator.naturalOrder()).get();
		  System.out.println(intVal);
		 

		/*
		 * Integer intValMin=numList.stream().min(Comparator.naturalOrder()).get();
		 * System.out.println(intValMin);
		 */

		// numList.stream().filter(s->Collections.frequency(numList, s)==1);

		//numList.parallelStream().map(n -> n * 2).forEach(System.out::println);
		
	//	numList.stream().sorted().limit(3).forEach(System.out::println);
	}
}
