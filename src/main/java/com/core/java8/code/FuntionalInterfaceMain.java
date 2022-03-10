package com.core.java8.code;

public class FuntionalInterfaceMain implements FuntionalInt {

	public static void main(String[] args) {

		FuntionalInterfaceMain main = new FuntionalInterfaceMain();

		main.bar();

		System.out.println(main.print());

		System.out.println(FuntionalInt.display("hELLO"));

		FuntionalInt.main(args);

	}

	@Override
	public void bar() {

		System.out.println("bar method overriden ");

	}
}
