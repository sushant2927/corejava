package com.core.multithreading.prac;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterantLock implements Runnable {

	private static ReentrantLock lock = new ReentrantLock(true);

	@Override
	public void run() {
		lock.lock();
		System.out.println(lock.isLocked());
		System.out.println(Thread.currentThread().getName());
		lock.unlock();
		System.out.println(lock.isLocked());
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		ReenterantLock reenterantLock=new ReenterantLock();
		
		Thread t1=new Thread(reenterantLock);
		Thread t2=new Thread(reenterantLock);
		Thread t3=new Thread(reenterantLock);
		Thread t4=new Thread(reenterantLock);
		t1.setName("one");
		t2.setName("two");
		t3.setName("three");
		t4.setName("four");
		
		t1.start();
	//	t1.join();
		t2.start();
		//t2.join();
		t3.start();
		//t3.join();
		t4.start();
		//t4.join();
		
	}

}
