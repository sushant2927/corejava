package com.core.java.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeWorkingInCity {

	public static void main(String[] args) {

		List<EmpDetails> details = new ArrayList<EmpDetails>();

		details.add(new EmpDetails(101, "Jack", "Mumbai"));
		details.add(new EmpDetails(102, "Ram", "Pune"));
		details.add(new EmpDetails(103, "Rohan", "Delhi"));
		details.add(new EmpDetails(104, "Sumit", "Bangalore"));
		details.add(new EmpDetails(105, "Vijay", "Bangalore"));
		details.add(new EmpDetails(106, "Vinay", "Mumbai"));
		details.add(new EmpDetails(107, "Jacobe", "Mumbai"));
		details.add(new EmpDetails(108, "Tim", "Pune"));

		// details.stream().filter(s->s.getCity().equalsIgnoreCase("Bangalore")).forEach(s->System.out.println(s.name));

		/*
		 * List<EmpDetails> newList =
		 * details.stream().filter(s->s.getName().equalsIgnoreCase("Tim")) .peek(f ->
		 * f.setCity("Mumbai")) .collect(Collectors.toList());
		 * 
		 * for (EmpDetails empDetails : newList) {
		 * 
		 * System.out.println(empDetails.getName()+"    "+empDetails.getCity()); }
		 * 
		 * 
		 * Map<String, Long>
		 * map=details.stream().collect(Collectors.groupingBy(EmpDetails::getCity,
		 * Collectors.counting()));
		 * 
		 * for (Map.Entry<String, Long> entry : map.entrySet()) {
		 * 
		 * System.out.println(entry.getKey()+"  "+entry.getValue());
		 * 
		 * }
		 * 
		 * List<Integer> intList=Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		 * 
		 * intList.parallelStream().filter(s->s%2==0).map(s->s*2).forEach(System.out::
		 * println);
		 */

		details.stream().map(s -> s.city).distinct().forEach(System.out::println);
		
		System.out.println("Employees living in mumbai");
		
		details.stream().filter(s->s.getCity().equalsIgnoreCase("Mumbai")).forEach(s->System.out.println(s.getName()));
	}
}

class EmpDetails {

	int id;
	String name;
	String city;

	public EmpDetails() {

	}

	public EmpDetails(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}