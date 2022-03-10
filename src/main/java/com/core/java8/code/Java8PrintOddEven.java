package com.core.java8.code;

public class Java8PrintOddEven {

	int count = 1;

	int N = 10;

	public static void main(String[] args) {

		Java8PrintOddEven oddEven = new Java8PrintOddEven();

		Runnable run = () -> {

			oddEven.printOdd();
		};

		Runnable run2 = () -> {

			oddEven.printEven();
		};

		Thread t1 = new Thread(run);
		Thread t2 = new Thread(run2);

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void printOdd() {

		synchronized (this) {

			while (count < N) {

				while (count % 2 == 0) {

					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				System.out.println(count);
				notify();
				count++;
			}

		}
	}

	public void printEven() {

		synchronized (this) {
			while (count < N) {
				while (count % 2 == 1) {

					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				System.out.println(count);
				notify();
				count++;
			}

		}

	}
}
