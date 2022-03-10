package com.core.java8.code;

@FunctionalInterface
public interface FuntionalInt {

	// single abstract method
	public void bar();

	// default methods
	public default String print() {
		return "default method inside Funtional Interface";
	}

	// static method
	public static String display(String msg) {

		return msg;
	}

	// static main method
	public static void main(String[] args) {
		System.out.println("Main method inside Funtional Interface");
	}
}
