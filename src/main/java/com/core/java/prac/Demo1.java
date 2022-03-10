package com.core.java.prac;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo1 {

	
	public static void main(String[] args) {
		
		
		int arr[]= {1,2,3,4,1,23};
		
		List<Integer> list=Arrays.asList(1,2,3,4,1,23);
		
	List<Integer> result=	list.stream().distinct().collect(Collectors.toList());
	
	for (Integer integer : result) {
		
		System.out.println(integer);
		
	}
	}
}
