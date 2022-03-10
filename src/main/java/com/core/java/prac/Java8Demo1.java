package com.core.java.prac;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

class Employee {

	int empid;
	String empname;
	String empdept;
	int empsalary;
	String project;
	String designation;
	int yearOfJoining;
	int age;

	public Employee(int empid, String empname, String empdept, int empsalary, String project, String designation,
			int yearOfJoining, int age) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.empdept = empdept;
		this.empsalary = empsalary;
		this.project = project;
		this.designation = designation;
		this.yearOfJoining = yearOfJoining;
		this.age = age;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmpdept() {
		return empdept;
	}

	public void setEmpdept(String empdept) {
		this.empdept = empdept;
	}

	public int getEmpsalary() {
		return empsalary;
	}

	public void setEmpsalary(int empsalary) {
		this.empsalary = empsalary;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}
	
	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empdept=" + empdept + ", empsalary=" + empsalary
				+ ", project=" + project + ", designation=" + designation + ", yearOfJoining=" + yearOfJoining
				+ ", age=" + age + "]";
	}



}

public class Java8Demo1 {

	public static void main(String[] args) {

		Employee emp1 = (new Employee(101, "David Warner", "Capital Markets", 2400000, "payments", "lead tech",2014,29));
		Employee emp2 = (new Employee(102, "Jon Doe", "GBM", 2100000, "golden eye", "sse",2016,27));
		Employee emp3 = (new Employee(103, "Ravi Kumar", "GBM", 2200000, "golden eye", "sse",2016,26));
		Employee emp4 = (new Employee(104, "Jack Jill", "Capital Markets", 2500000, "payments", "lead tech",2014,30));
		Employee emp5 = (new Employee(105, "Mahesh Mattu", "ITID", 2700000, "ivr", "scs",2010,35));
		Employee emp6 = (new Employee(106, "Marty Macfly", "ITID", 1600000, "ivr", "tester",2018,25));
		Employee emp7 = (new Employee(107, "Sunil Shetty", "Capital Markets", 1500000, "payments", "tester",2020,21));

		List<Employee> emplist = new ArrayList<>();
		emplist.add(emp1);
		emplist.add(emp2);
		emplist.add(emp3);
		emplist.add(emp4);
		emplist.add(emp5);
		emplist.add(emp6);
		emplist.add(emp7);

		emplist.stream().sorted(Comparator.comparingInt(Employee::getEmpsalary).reversed())
				.forEach(s -> System.out.println(s.empid + "   " + s.empsalary));

		Optional<Employee> result = emplist.stream().sorted(Comparator.comparingInt(Employee::getEmpsalary).reversed())
				.skip(1).findFirst();

		System.out.println(result.get());
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		List<Integer> salaryBonus = emplist.stream().map(e -> e.empsalary + 1000).collect(Collectors.toList());

		System.out.println(salaryBonus);

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		emplist.stream().map(Employee::getEmpdept).distinct().forEach(System.out::println);

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println("get avg salary as per dept");

		Map<String, Double> deptAvgSalMap = emplist.stream()
				.collect(Collectors.groupingBy(Employee::getEmpdept, Collectors.averagingInt(Employee::getEmpsalary)));

		System.out.println(deptAvgSalMap);

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println("highest salary employee");

		Optional<Employee> empHIghList = emplist.stream()
				.collect(Collectors.maxBy(Comparator.comparingInt(Employee::getEmpsalary)));

		System.out.println(empHIghList.get().empname + "   " + empHIghList.get().empsalary);

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println("get the employee details who joined before 2016");
		
		List<Employee> listyesrofJoining= emplist.stream().filter(e->e.yearOfJoining<2016).collect(Collectors.toList());
		
		for (Employee employee : listyesrofJoining) {
			System.out.println(employee.empid+"  "+employee.empname+"  "+employee.yearOfJoining);
		}
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println("get the employee names who joined before 2016");
		
		emplist.stream().filter(e->e.yearOfJoining<2015).map(e->e.empname).forEach(System.out::println);

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println("count number of employee in each department");
		
		Map<String, Long> deptCountMap= emplist.stream().collect(Collectors.groupingBy(Employee::getEmpdept,Collectors.counting()));
		
		System.out.println(deptCountMap);
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println("Averavge salary of each dept");
		
		Map<String, Double> avgSalMap=  emplist.stream().collect(Collectors.groupingBy(Employee::getEmpdept, Collectors.averagingInt(Employee::getEmpsalary)));
		
		System.out.println(avgSalMap);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println("Find the recent employee who joined the company");
		
		Optional<Employee> recenrtEmp=  emplist.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getYearOfJoining)));
		
		System.out.println(recenrtEmp.get().empid+"  "+recenrtEmp.get().getEmpname());
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println("find the youngest employee of capitals markets");
		
		Optional<Employee> youngestEmp =emplist.stream().filter(e->e.empdept.equalsIgnoreCase("Capital Markets")).min(Comparator.comparingInt(Employee::getAge));
		
		System.out.println(youngestEmp.get().empid+"  "+youngestEmp.get().getEmpname()+"  "+youngestEmp.get().empdept+"  "+youngestEmp.get().age);
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println("highest experience in the organization");
		
		Optional<Employee> seniorEmp= emplist.stream().collect(Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining)));
		
		System.out.println(seniorEmp.get().getEmpid()+"   "+seniorEmp.get().getEmpname()+"   "+seniorEmp.get().getYearOfJoining()+"   "+seniorEmp.get().getEmpdept());
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println("list Names of employess as per dept");
		
		Map<Integer, List<Employee>> empdeptList= emplist.stream().collect(Collectors.groupingBy(Employee::getEmpid));
		
		Set<Entry<Integer, List<Employee>>> entrySet=empdeptList.entrySet();
		
		for (Entry<Integer, List<Employee>> entry : entrySet) {
			
			System.out.println("Dept name "+entry.getKey());
			
			System.out.println("================================");
			
			List<Employee> empnameslist=entry.getValue();
			for(Employee employee :empnameslist) {
				
				System.out.println(employee.getEmpid()+"  "+employee.getEmpname()+"  "+employee.empdept);
				
			}
			
			System.out.println("================================");

			
		}
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");		
		System.out.println();
		System.out.println("average salary and total salary organization");
		
		
		DoubleSummaryStatistics summaryStatistics =emplist.stream().collect(Collectors.summarizingDouble(Employee::getEmpsalary));
		
		System.out.println("Average salary of organization : "+summaryStatistics.getAverage());
		
		System.out.println("Total salary of organization : "+summaryStatistics.getSum());

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println("find employee age greater the 25 and those younger then 25");
		
		Map<Boolean, List<Employee>> ageDifferMap= emplist.stream().collect(Collectors.partitioningBy(e->e.age>25));
		
		Set<Entry<Boolean, List<Employee>>> entry=ageDifferMap.entrySet();
		
		for (Entry<Boolean, List<Employee>> entry2 : entry) {
			
			
			if (entry2.getKey()) {
				System.out.println("Employee older the 25 years old");
			}
			
			else {
				System.out.println("Employee younger then 25 years old");
			}
			
			List<Employee> namelist=entry2.getValue();
			
			for(Employee employee : namelist) {
				
				System.out.println(employee.empname);
			}
		}
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println("oldest employee and their dept and project");
		
		Optional<Employee> oldestEmp=emplist.stream().max(Comparator.comparingInt(Employee::getAge));
		
		System.out.println(oldestEmp.get().empname+"  "+oldestEmp.get().age);
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println("find highest salary employee");
		
		
		emplist.stream().sorted(Comparator.comparingDouble(Employee::getEmpsalary).reversed()).limit(1).map(Employee::getEmpname).forEach(System.out::println);
		
		
		}
		
	}


