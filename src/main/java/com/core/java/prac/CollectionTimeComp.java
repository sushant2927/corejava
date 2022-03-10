package com.core.java.prac;

import java.util.LinkedList;

public class CollectionTimeComp {

	
	public static void main(String[] args) {
		LinkedList<String> list =new LinkedList<String>();
		
		list.add("Java");
		list.add("Python");
		list.add("C");
		list.add("Cobal");
		list.add("Ruby");
		list.add("DataBase");
		
		System.out.println(list);
		list.remove("C");
		System.out.println(list);
		
	}
}
