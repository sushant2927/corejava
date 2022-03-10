package com.core.java.mock;

public class StackMemoryDemo {

	public static void main(String[] args) {
		int x = 1;
		int y = 2;

		int result = sum(x, y);
	}

	private static int sum(int x, int y) {
		int s = x + y;
		return s;
	}

}
