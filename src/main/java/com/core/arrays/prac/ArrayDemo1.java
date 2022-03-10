package com.core.arrays.prac;

public class ArrayDemo1 {

	
	public static void main(String[] args) {
		int arr[]= {1,25,2,4,2,11,5};
		
		int sum=29;
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = i+1; j < arr.length; j++) {
				
				if (arr[i]+arr[j]==sum) {
					System.out.println(arr[i]+" + "+arr[j]+" = "+sum);
					break;
				}
			}
			
		}
		
		
	}
}
