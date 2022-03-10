package com.core.java.mock;

public class Demo2 {

	{System.out.println("inside instance block");}
	static {
		
		System.out.println("inside static block");
	}
	
	static {
		
		System.out.println("inside overloaded static block");
	}
	

	
	public Demo2() {
		
		System.out.println("inside constructor");
	}
	
	static void print() {
		System.out.println("inside static print method");
		
	}
	public static void main(String[] args) {
		
		Demo2 demo2=new Demo2();
		
		print();
		
		Demo2.print();
		
		//Demo2 demo22=new Demo2();
	}
}
