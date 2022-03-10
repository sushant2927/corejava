package com.core.multithreading.prac;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintOddEven {

	int counter = 1;
	int N = 10;

	public static void main(String[] args) throws InterruptedException {

		PrintOddEven oddEven = new PrintOddEven();
		// using normal threads
		/*
		 * Thread t1 = new Thread(new Runnable() {
		 * 
		 * @Override public void run() { oddEven.printEven();
		 * 
		 * } });
		 * 
		 * Thread t2 = new Thread(new Runnable() {
		 * 
		 * @Override public void run() { oddEven.printOdd();
		 * 
		 * } });
		 * 
		 * t1.start();
		 * 
		 * t2.start(); t1.join(); t2.join();
		 */

		// using executor
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(new Runnable() {

			@Override
			public void run() {
				oddEven.printEven();

			}
		});

		service.execute(new Runnable() {

			@Override
			public void run() {
				oddEven.printOdd();

			}
		});
	}

	public void printEven() {
		System.out.println("Even " + Thread.holdsLock(this));
		synchronized (this) {
			System.out.println("Even " + Thread.holdsLock(this));
			while (counter < N) {

				while (counter % 2 == 1) {

					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				System.out.println(counter);
				counter++;
				notify();
			}
		}

	}

	public void printOdd() {
		System.out.println("Odd " + Thread.holdsLock(this));
		synchronized (this) {
			System.out.println("Odd " + Thread.holdsLock(this));
			while (counter < N) {

				while (counter % 2 == 0) {

					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				System.out.println(counter);

				counter++;
				notify();
			}
		}
	}

}