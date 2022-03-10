package com.core.multithreading.prac;

public class ThreadSuspend implements Runnable{

	public static void main(String[] args) throws InterruptedException {
		
		ThreadSuspend suspend=new ThreadSuspend();
		Thread t1=new Thread(suspend);
		
		t1.start();
		
		t1.wait();
	}
	
	@Override
	public void run() {
	
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
