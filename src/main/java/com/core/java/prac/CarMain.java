package com.core.java.prac;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

class CarDetails {

	String name;
	int modelNum;
	int millage;
	String color;

	public CarDetails() {

	}

	@Override
	public int hashCode() {
		return Objects.hash(modelNum, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarDetails other = (CarDetails) obj;
		return Objects.equals(name, other.name) && modelNum == other.modelNum;
	}

	public CarDetails(String name, int modelNum, int millage, String color) {
		super();
		this.name = name;
		this.modelNum = modelNum;
		this.millage = millage;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getModelNum() {
		return modelNum;
	}

	public void setModelNum(int modelNum) {
		this.modelNum = modelNum;
	}

	public int getMillage() {
		return millage;
	}

	public void setMillage(int millage) {
		this.millage = millage;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "CarDetails [name=" + name + ", modelNum=" + modelNum + ", millage=" + millage + ", color=" + color
				+ "]";
	}

}

public class CarMain {

	public static void main(String[] args) {

		List<CarDetails> list = new ArrayList<>();

		list.add(new CarDetails("Maruti", 101, 17, "black"));
		list.add(new CarDetails("Toyota", 102, 18, "black"));
		list.add(new CarDetails("Tata", 113, 15, "red"));
		list.add(new CarDetails("Tata", 113, 15, "red"));
		list.add(new CarDetails("Maruti", 101, 17, "white"));
		list.add(new CarDetails("Maruti", 103, 17, "blue"));
		list.add(new CarDetails("Maruti", 103, 17, "black"));

		Set<CarDetails> uniqueCars = new HashSet<CarDetails>(list);

		uniqueCars.forEach(s -> System.out.println(s));

		List<CarDetails> listnew = list.stream()
				.sorted(Comparator.comparing(CarDetails::getModelNum)
						.thenComparing((c1, c2) -> (int) c2.getMillage() - c1.getMillage()))
				.collect(Collectors.toList());

		for (CarDetails carDetails : listnew) {

			System.out.println("Car name " + carDetails.getName() + "    modelnum " + carDetails.getMillage()
					+ "   Mileage  " + carDetails.getMillage() + "   caolor  " + carDetails.getColor());

		}
	}
}
