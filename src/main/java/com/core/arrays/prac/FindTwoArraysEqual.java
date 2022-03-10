package com.core.arrays.prac;

public class FindTwoArraysEqual {

	
	public static void main(String[] args) {
		
		int arr1[]= {1,2,3,4,5,6,7};
		int arr2[]= {1,2,3,4,5,6,7};
		
		boolean equality=true;
		if (arr1.length==arr2.length) {
			
			for (int i = 0; i < arr2.length; i++) {
				
				if (arr1[i]!=arr2[i]) {
					equality=false;
				}
			}
		}
		
		else {
		equality=false;
		}
		
		System.out.println("arrays are equal :-"+equality);

	}
}
