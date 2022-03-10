package com.core.arrays.prac;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Coding {

	
	public static void main(String[] args) {
		
		
		Employee e1=new Employee(1, 11, 3);
		Employee e2=new Employee(2, 12, 4);
		Employee e3=new Employee(3, 13, 1);
		
		List<Employee> list=new ArrayList<Employee>();
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		
		Map<Integer, Employee> empMap=list.stream().collect(Collectors.toMap(Employee::getId, l->l));
		
		DoubleSummaryStatistics statistics=list.stream().collect(Collectors.summarizingDouble(Employee::getRating));
		
		
		Map<Integer, Double> avgmapp=list.stream().collect(Collectors.groupingBy(Employee::getDeptid,Collectors.averagingDouble(Employee::getRating)));
		
		
	}
}

class Employee{
	
	int id;
	int deptid;
	int rating;
	
	
	public Employee(int id, int deptid, int rating) {
		super();
		this.id = id;
		this.deptid = deptid;
		this.rating = rating;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getDeptid() {
		return deptid;
	}


	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", deptid=" + deptid + ", rating=" + rating + "]";
	}
	
	
	
	
}
