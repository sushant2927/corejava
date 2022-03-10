package com.core.java.prac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class EmployeeMain {

	public static void main(String[] args) {

		List<EmpData> employeeList = new ArrayList<EmpData>();

		employeeList.add(new EmpData(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0, "A"));
		employeeList.add(new EmpData(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0, "I"));
		employeeList.add(new EmpData(133, "Martin Theron", 29, "Male", "HR", 2012, 18000.0, "A"));
		employeeList.add(new EmpData(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0, "A"));
		employeeList.add(new EmpData(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0, "I"));
		employeeList.add(new EmpData(166, "Iqbal Hussain", 43, "Male", "Sales And Marketing", 2016, 10500.0, "I"));
		employeeList.add(new EmpData(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0, "A"));
		employeeList.add(new EmpData(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0, "I"));
		employeeList.add(new EmpData(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0, "A"));
		employeeList.add(new EmpData(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5, "I"));
		employeeList.add(new EmpData(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0, "A"));
		employeeList.add(new EmpData(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0, "A"));
		employeeList.add(new EmpData(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0, "I"));
		employeeList.add(new EmpData(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5, "A"));
		employeeList.add(new EmpData(255, "Ali Baig", 23, "Male", "Sales And Marketing", 2018, 12700.0, "A"));
		employeeList.add(new EmpData(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0, "I"));
		employeeList.add(new EmpData(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0, "A"));

		System.out.println("How many Males and Females int he organization");

		Map<String, Long> mapGender = employeeList.stream()
				.collect(Collectors.groupingBy(EmpData::getGender, Collectors.counting()));

		for (Map.Entry<String, Long> entry : mapGender.entrySet()) {
			System.out.println(entry.getKey() + "   " + entry.getValue());
		}

		System.out.println("==================================================");

		System.out.println("Print name of all the departments in organization");

		employeeList.stream().map(s -> s.getDepartment()).distinct().forEach(System.out::println);

		System.out.println("==================================================");

		System.out.println("Average age of male and female employee in organization");

		Map<String, Double> mapAvgAge = employeeList.stream()
				.collect(Collectors.groupingBy(EmpData::getGender, Collectors.averagingInt(EmpData::getAge)));

		System.out.println(mapAvgAge);

		System.out.println("==================================================");

		System.out.println("Highest paid employee in organization");

		Optional<EmpData> highestEmp = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(EmpData::getSalary)));

		System.out.println(highestEmp);

		System.out.println("==================================================");

		System.out.println("Details of employee who joined organization after 2015");

		employeeList.stream().filter(s -> s.yearOfJoining > 2015).forEach(System.out::println);

		System.out.println("Name of employee who joined organization after 2015");

		employeeList.stream().filter(s -> s.yearOfJoining > 2015).map(EmpData::getName).forEach(System.out::println);

		System.out.println("==================================================");

		System.out.println("Count the number of Employees in each department");

		Map<String, Long> NumEmpInDeptMap = employeeList.stream()
				.collect(Collectors.groupingBy(EmpData::getDepartment, Collectors.counting()));

		for (Entry<String, Long> entry : NumEmpInDeptMap.entrySet()) {
			System.out.println(entry.getKey() + "  " + entry.getValue());

		}

		System.out.println("==================================================");

		System.out.println("department names where employee count >2");

		Map<String, Long> map = employeeList.stream()
				.collect(Collectors.groupingBy(EmpData::getDepartment, TreeMap::new, Collectors.counting()));

		for (Entry<String, Long> entry : map.entrySet()) {
			if (entry.getValue() > 2) {

				System.out.println(entry.getKey() + "  " + entry.getValue());
			}

		}

		System.out.println("==================================================");

		System.out.println("department with highest number of employees");

		Map<String, Long> deptHighestCountMap = employeeList.stream()
				.collect(Collectors.groupingBy(EmpData::getDepartment, Collectors.counting()));

		// k= dept name and vlaue = count no rmps in that dept
		Optional<Entry<String, Long>> optValue = deptHighestCountMap.entrySet().stream()
				.max(Comparator.comparing(Map.Entry::getValue));

		Long maxValue = Collections.max(deptHighestCountMap.values());

		System.out.println(optValue.get().getKey() + "  " + optValue.get().getValue());

		Map<String, Long> deptHighestCountMap2 = deptHighestCountMap.entrySet().stream()
				.sorted(Comparator.comparingLong(Map.Entry::getValue)).filter(m -> m.getValue() == maxValue)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println("Dept with the most highest employees in the org");
		System.out.println(deptHighestCountMap2);

		System.out.println("Dept with the most highest employees in the org///Shahul solution");

		employeeList.stream().collect(Collectors.groupingBy(EmpData::getDepartment, TreeMap::new, Collectors.toList()))
				.lastEntry().getValue().forEach(System.out::println);

		// Stream<Entry<String, Long>> maxDept=
		// deptHighestCountMap.entrySet().stream().sorted(Comparator.comparingLong(Map.Entry::getValue)).filter(m->m.getValue()==maxValue);

		/*
		 * System.out.println("==================================================");
		 * 
		 * System.out.println("top 3 employees with highest salary");
		 * 
		 * employeeList.stream().sorted(Comparator.comparingDouble(EmpData::getSalary).
		 * reversed()).limit(3) .map(EmpData::getName).forEach(System.out::println);
		 * 
		 * System.out.println("==================================================");
		 * 
		 * System.out.println("top 3 ACTIVE employees with highest salary");
		 * 
		 * employeeList.stream().sorted(Comparator.comparingDouble(EmpData::getSalary).
		 * reversed()) .filter(s ->
		 * s.getActiveStatus().equalsIgnoreCase("A")).limit(3).map(EmpData::getName)
		 * .forEach(System.out::println);
		 * 
		 * System.out.println("==================================================");
		 * 
		 * System.out.println("print employee names who are Inactive");
		 * 
		 * employeeList.stream().filter(s ->
		 * s.getActiveStatus().equalsIgnoreCase("I")).map(EmpData::getName)
		 * .forEach(System.out::println);
		 * 
		 * System.out.println("==================================================");
		 * 
		 * System.out.println("print department with highest number of employees");
		 * 
		 * Map<String, Long> highestEmpCount = employeeList.stream()
		 * .collect(Collectors.groupingBy(EmpData::getDepartment, TreeMap::new,
		 * Collectors.counting()));
		 * 
		 * Optional<Entry<String, Long>> mapHighest =
		 * highestEmpCount.entrySet().stream()
		 * .max(Comparator.comparing(Map.Entry::getValue));
		 * 
		 * System.out.println(mapHighest.get().getKey() + "   " +
		 * mapHighest.get().getValue());
		 * 
		 * System.out.println("==================================================");
		 * 
		 * System.out.println("print total number of employee in each department");
		 * 
		 * Map<String, Long> empInEachDeptMap = employeeList.stream()
		 * .collect(Collectors.groupingBy(EmpData::getDepartment, TreeMap::new,
		 * Collectors.counting()));
		 * 
		 * for (Map.Entry<String, Long> entry : empInEachDeptMap.entrySet()) { String
		 * key = entry.getKey(); Long val = entry.getValue();
		 * 
		 * System.out.println(key + "  " + val);
		 * 
		 * }
		 * 
		 * System.out.
		 * println("print total number of employee in each department in sorted by value"
		 * );
		 * 
		 * empInEachDeptMap.entrySet().stream().sorted(Map.Entry.comparingByValue(
		 * Comparator.reverseOrder())) .forEach(m -> System.out.println(m.getKey() +
		 * "  " + m.getValue()));
		 */

	}
}

class EmpData {

	int id;

	String name;

	int age;

	String gender;

	String department;

	int yearOfJoining;

	double salary;

	String activeStatus;

	public EmpData() {

	}

	public EmpData(int id, String name, int age, String gender, String department, int yearOfJoining, double salary,
			String activeStatus) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
		this.activeStatus = activeStatus;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	@Override
	public String toString() {
		return "EmpData [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
				+ department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + ", activeStatus="
				+ activeStatus + "]";
	}

}