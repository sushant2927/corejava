package com.core.java.prac;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class ReverseArrayJava8 {

	
	public static void main(String[] args) {
		Integer arr[]= {1,8,2,4,5,7,3,1};
		
	List<Integer> list=Arrays.asList(arr);
	
	Collections.sort(list, Comparator.reverseOrder());
	
	System.out.println(list);
	
	Collections.sort(list);
	
	System.out.println(list);
	}
}
