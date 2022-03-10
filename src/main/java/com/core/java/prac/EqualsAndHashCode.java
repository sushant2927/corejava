package com.core.java.prac;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EqualsAndHashCode {

	
	public static void main(String[] args) {
		
		HashMap<Emp, Integer> map=new HashMap<Emp, Integer>();
		
		Emp emp1=new Emp(101, "Ravi", "Bnagalore");
		Emp emp2=new Emp(102, "Ravi", "Bnagalore");
		Emp emp3=new Emp(103, "Ravi", "Bnagalore");
		Emp emp4=new Emp(101, "Sushant", "Bnagalore");
		
		map.put(emp1, 101);
		map.put(emp2, 101);
		map.put(emp3, 101);
		map.put(emp4, 101);
		
	for (Map.Entry<Emp, Integer> entry : map.entrySet()) {
		Emp key = entry.getKey();
		Integer val = entry.getValue();
		
		System.out.println(key +"   "+val);
		
	}
	
	
	}
}


class Emp{
	
	int id;
	
	String name;
	
	String location;
	
	public Emp() {
		
		
	}

	public Emp(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		
		
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", location=" + location + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return true;
		if (getClass() != obj.getClass())
			return true;
		Emp other = (Emp) obj;
		return id == other.id ;
	}
	
	
	
	
}