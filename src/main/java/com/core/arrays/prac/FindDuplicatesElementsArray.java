package com.core.arrays.prac;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicatesElementsArray {

	
	public static void main(String[] args) {
		
		String arr[]= {"Java","Python","Shikha","Java","C","Python"};
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = i+1; j < arr.length; j++) {
				
				if (arr[i]==arr[j]&& i!=j) {
					System.out.println("Duplicate item :- "+arr[i]);
				}
			}
		}
		
		System.out.println("Find duplicates using sets for more optimize way");
		
		Set<String> set=new HashSet<String>();
		
		for (String string : arr) {
			
			if (!set.add(string)) {
			System.out.println("Duplicate item using sets :- "+string);	
			}
		}
	}
}
