package com.core.java8.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StudentsDemo {

	public static void main(String[] args) {

		List<StuDetails> list = new ArrayList<StuDetails>();

		list.add(new StuDetails(101, "Ravi", 22, 85, "cse"));
		list.add(new StuDetails(102, "Suresh", 21, 82, "mech"));
		list.add(new StuDetails(103, "Mahesh", 22, 83, "it"));
		list.add(new StuDetails(104, "Sunil", 24, 90, "ee"));
		list.add(new StuDetails(105, "Anil", 21, 84, "ece"));
		list.add(new StuDetails(106, "Ramesh", 20, 87, "cse"));
		list.add(new StuDetails(107, "Ganesh", 19, 75, "cse"));
		list.add(new StuDetails(108, "Dinesh", 18, 75, "ece"));
		list.add(new StuDetails(111, "Mary", 23, 89, "mech"));
		list.add(new StuDetails(112, "Mark", 26, 86, "ee"));

		// list.stream().sorted(Comparator.comparingInt(StuDetails::getAge).reversed()).forEach(System.out::println);

		Optional<StuDetails> result = list.stream().sorted(Comparator.comparingInt(StuDetails::getAge).reversed())
				.skip(1).findFirst();

		System.out.println(result.get().getName()+"  "+result.get().getAge());
		
		Optional<StuDetails> result2=	list.stream().sorted((o1,o2)->o2.getAge()-o1.getAge()).findFirst();
		
		System.out.println(result2.get().getName()+"  "+result2.get().getAge());
		
		
		
		
	}
}

class StuDetails {

	int id;
	String name;
	int age;
	double marks;
	String branch;

	public StuDetails() {

	}

	public StuDetails(int id, String name, int age, double marks, String branch) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.marks = marks;
		this.branch = branch;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "StuDetails [id=" + id + ", name=" + name + ", age=" + age + ", marks=" + marks + ", branch=" + branch
				+ "]";
	}

}