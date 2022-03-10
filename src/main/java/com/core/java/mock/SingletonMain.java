package com.core.java.mock;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonMain {

	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException, IOException, ClassNotFoundException, CloneNotSupportedException {
		
		SingletonDemo demo=SingletonDemo.getInstance();
		SingletonDemo demo2=SingletonDemo.getInstance();
		SingletonDemo demo3=null;
		System.out.println(demo.hashCode());
		System.out.println(demo2.hashCode());
		
		//reflection and prevention from it
		
		/*
		 * try { Constructor constructor=SingletonDemo.class.getDeclaredConstructor();
		 * constructor.setAccessible(true); demo3=(SingletonDemo)
		 * constructor.newInstance(); } catch (NoSuchMethodException | SecurityException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * System.out.println(demo3.hashCode());
		 */
		
		//serialization and prevention
		/*
		 * SingletonDemo demo4=SingletonDemo.getInstance();
		 * 
		 * ObjectOutput out=new ObjectOutputStream(new FileOutputStream("file.txt"));
		 * out.writeObject(demo4); out.close();
		 * 
		 * ObjectInput in=new ObjectInputStream(new FileInputStream("file.txt"));
		 * SingletonDemo demo5= (SingletonDemo) in.readObject(); in.close();
		 * 
		 * System.out.println(demo5.hashCode());
		 */
		
		//Clonning and preventing from it
		SingletonDemo demo6=(SingletonDemo) demo2.clone();
		
		System.out.println(demo6.hashCode());
	}
}
