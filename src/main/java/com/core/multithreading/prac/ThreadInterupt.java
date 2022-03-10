package com.core.multithreading.prac;

public class ThreadInterupt implements Runnable {

	public static void main(String[] args) {
		ThreadInterupt interupt = new ThreadInterupt();

		Thread t1 = new Thread(interupt);
		t1.setName("MyThread");
		t1.start();
		
		t1.interrupt();
	}

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {

			System.out.println(Thread.currentThread().getName() + "  " + i);

			try {
				Thread.sleep(5000);
				if (Thread.interrupted()) {
					return;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			System.out.println("Thread Interupted");
			}

		}

	}

}
