package com.core.multithreading.prac;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerNode {

	List<Integer> list = new ArrayList<Integer>();
	int capacity = 2;

	public static void main(String[] args) throws InterruptedException {
		ProducerConsumerNode node = new ProducerConsumerNode();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					node.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					node.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}

	public void produce() throws InterruptedException {

		int value = 0;
		while (true) {

			synchronized (this) {

				while (list.size() == capacity) {
					wait();
				}

				System.out.println("Producer produced " + value);

				list.add(value++);

				notify();

				Thread.sleep(1000);
			}
		}
	}

	public void consumer() throws InterruptedException {

		while (true) {

			synchronized (this) {

				while (list.size() == 0) {
					wait();
				}

				int val = list.remove(0);
				System.out.println("Consumer consumed " + val);

				notify();

				Thread.sleep(1000);
			}

		}
	}

}
