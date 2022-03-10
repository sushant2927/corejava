package com.core.java.prac;

import java.io.IOException;

public class Child extends Parent {

	public void print() {

		System.out.println("Child Method");
	}


	public static void main(String[] args) {
		Parent p = new Child();

		p.print();
		
		String s1="abc";



		String s2="abc";



		String s3=new String("abc");
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s3.equals(s2));
		
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s3==s2);
//	Child c=new Parent(); no allowed

	}
}
