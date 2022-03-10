package com.core.arrays.prac;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapDemo {

	
	public static void main(String[] args) {
		HashMap<Integer, String> map=new HashMap<Integer, String>();
		
		map.put(1, "Hello");
		map.put(2, "how");
		map.put(3, "are");
		map.put(4, "you");
		map.put(5, "friends");
		
	
		
		  Iterator hmIterator = map.entrySet().iterator();
		  
		  while (hmIterator.hasNext()) { Map.Entry mapElement =
		  (Map.Entry)hmIterator.next();
		  
		  map.put(6, "hi"); }
		 
		
		/*
		 * for (Map.Entry<Integer, String> entry : map.entrySet()) { Integer key =
		 * entry.getKey(); String val = entry.getValue();
		 * 
		 * map.put(6, "hi");
		 * 
		 * }
		 */
	}
}
