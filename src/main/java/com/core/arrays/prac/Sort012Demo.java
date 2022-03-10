package com.core.arrays.prac;

import java.lang.invoke.SwitchPoint;
import java.util.Iterator;

public class Sort012Demo {

	public static void main(String[] args) {

		int arr[] = { 1, 0, 2, 1, 1, 0, 2, 0, 2 };

		int cnt0 = 0, cnt1 = 0, cnt2 = 0;
		for (int i = 0; i < arr.length; i++) {

			switch (arr[i]) {
			case 0:
				cnt0++;
				break;

			case 1:
				cnt1++;
				break;

			case 2:
				cnt2++;
				break;

			}
		}
		
		int i=0;
		
		while (cnt0>0) {
		
			arr[i++]=0;
			
			cnt0--;
		}
		
		while (cnt1>0) {
			
			arr[i++]=1;
			
			cnt1--;
		}
		
		while (cnt2>0) {
			
			arr[i++]=2;
			
			cnt2--;
		}
		
	int n=arr.length;
		  for (int j = 0; j < n; j++)
	            System.out.print(arr[j] + " ");
	}
}
