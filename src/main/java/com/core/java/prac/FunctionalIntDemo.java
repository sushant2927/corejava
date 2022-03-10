package com.core.java.prac;

@FunctionalInterface
public interface FunctionalIntDemo {

	public abstract void print();

	default void callM() {

		System.out.println("inside callM method");
	}

	public static void main(String[] args) {
		System.out.println("inside main method");
	}

	public static String display() {
		return "Display method from Functional Interface";

	}
}
