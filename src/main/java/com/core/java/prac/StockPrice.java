package com.core.java.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StockPrice {

	public String companyName;
	public double price;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public StockPrice(String companyName, double price) {
		super();
		this.companyName = companyName;
		this.price = price;
	}

	public static void main(String[] args) {

		StockPrice s1 = new StockPrice("TCS", 90);
		StockPrice s2 = new StockPrice("TCS", 80);
		StockPrice s3 = new StockPrice("TCS", 40);
		StockPrice s4 = new StockPrice("TCS", 50);
		// TCS 50
		StockPrice s5 = new StockPrice("INFO", 100);
		StockPrice s6 = new StockPrice("INFO", 90);
		StockPrice s7 = new StockPrice("INFO", 10);
		// INFO 90
		StockPrice s8 = new StockPrice("Synechron", 90);
		StockPrice s9 = new StockPrice("Synechron", 30);
		StockPrice s10 = new StockPrice("Synechron", 40);
		StockPrice s11 = new StockPrice("Synechron", 110);
		// synechron 80
		StockPrice s12 = new StockPrice("Capita", 90);
		StockPrice s13 = new StockPrice("Capita", 90);
		StockPrice s14 = new StockPrice("Capita", 80);
		// capita 70
		StockPrice s15 = new StockPrice("Zycus", 90);
		StockPrice s16 = new StockPrice("Zycus", 80);
		StockPrice s17 = new StockPrice("Zycus", 40);
		StockPrice s18 = new StockPrice("Zycus", 50);
		// zycus 50
		StockPrice s19 = new StockPrice("INFO", 100);
		StockPrice s20 = new StockPrice("INFO", 90);
		StockPrice s21 = new StockPrice("INFO", 10);

		StockPrice s22 = new StockPrice("TCS", 90);
		StockPrice s23 = new StockPrice("TCS", 80);
		StockPrice s33 = new StockPrice("TCS", 40);
		StockPrice s24 = new StockPrice("TCS", 50);
		StockPrice s25 = new StockPrice("INFO", 100);
		StockPrice s26 = new StockPrice("INFO", 90);
		StockPrice s27 = new StockPrice("INFO", 10);

		StockPrice s28 = new StockPrice("TCS", 90);
		StockPrice s29 = new StockPrice("TCS", 80);
		StockPrice s30 = new StockPrice("TCS", 40);
		StockPrice s31 = new StockPrice("TCS", 50);

		List<StockPrice> list = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16,
				s17, s18, s19, s20, s21, s22, s23, s24, s25, s26, s27, s28, s29, s30, s31);

		Map<String, DoubleSummaryStatistics> map = list.stream().collect(
				Collectors.groupingBy(StockPrice::getCompanyName, Collectors.summarizingDouble(StockPrice::getPrice)));

		for (Map.Entry<String, DoubleSummaryStatistics> entry : map.entrySet()) {
			String key = entry.getKey();
			DoubleSummaryStatistics val = entry.getValue();

			System.out.println("Company name :-" + key + "  min stock value :-" + val.getMin() + "  max stock value :-"
					+ val.getMax() + " avg stock value :- " + val.getAverage() +"  volatile price "+(val.getMax()-val.getMin()));

		}

	}

}
