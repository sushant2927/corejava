package com.core.java8.code;

import java.util.ArrayList;
import java.util.List;

public class LoopListJava8 {

	
	public static void main(String[] args) {
		
		 List<String> list = new ArrayList<>();
	      list.add("A");
	      list.add("B");
	      list.add("C");
	      list.add("D");
	      list.add("E");
	      
	      list.forEach(System.out::println);
	      
	      System.out.println(" filters the null value of a List.");
	      
	      List<String> list2 = new ArrayList<>();
	      list2.add("A");
	      list2.add("B");
	      list2.add(null);
	      list2.add("D");
	      list2.add(null);
	      
	      list2.stream().filter(s->s!=null).forEach(System.out::println);
	      
	      
	}
}
