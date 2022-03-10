package com.core.java.mock;

public final class SingletonDemo implements Cloneable {

	private static volatile SingletonDemo singletonDemo = null;

	private SingletonDemo() {

		// throw new RuntimeException();
	}

	public static SingletonDemo getInstance() {

		if (singletonDemo == null) {

			synchronized (SingletonDemo.class) {

				if (singletonDemo == null) {

					singletonDemo = new SingletonDemo();
				}
			}
		}
		return singletonDemo;

	}

	protected Object readResolve() {
		return singletonDemo;

	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		//return super.clone();
		
		throw new CloneNotSupportedException();
	}
	
	
}
