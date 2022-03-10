package com.core.multithreading.prac;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPool {

	int counter = 1;
	int N = 100;

	public static void main(String[] args) {

		int core = Runtime.getRuntime().availableProcessors();
		CustomThreadPool customThreadPool = new CustomThreadPool();
		ExecutorService service = new ThreadPoolExecutor(core, core, 0L, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<>(400));

		service.submit(new Runnable() {

			@Override
			public void run() {
				customThreadPool.printOdd();

			}
		});

		service.execute(new Runnable() {

			@Override
			public void run() {
				customThreadPool.printEven();

			}
		});

		service.submit(new Runnable() {

			@Override
			public void run() {
				customThreadPool.printOdd();

			}
		});

		service.execute(new Runnable() {

			@Override
			public void run() {
				customThreadPool.printEven();

			}
		});

	}

	public void printEven() {

		synchronized (this) {

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

		synchronized (this) {
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
