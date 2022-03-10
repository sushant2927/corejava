package com.core.java.mock;

public class Demo1 {

	int i;
	
	public Demo1(int i) {}
	
	public static void main(String[] args) {
	
	//	Demo1 demo1=new Demo1(); compile time error
		Demo1 demo2=new Demo1(10);
	}
}
