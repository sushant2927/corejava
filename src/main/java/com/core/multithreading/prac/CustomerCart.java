package com.core.multithreading.prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CustomerCart {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService service = Executors.newFixedThreadPool(10);

		Map<String, Integer> requestMap = new LinkedHashMap<String, Integer>();

		Map<String, Integer> requestMap2 = new LinkedHashMap<String, Integer>();

		List<Map<String, Integer>> reqList1 = new ArrayList<Map<String, Integer>>();
		List<Map<String, Integer>> reqList2 = new ArrayList<Map<String, Integer>>();

		// customer 1
		requestMap.put("Asus Laptop", 11);
		requestMap.put("HP Laptop", 20);
		requestMap.put("Dell Laptop", 12);
		requestMap.put("Kingston pendrive", 100);
		requestMap.put("Lenovo Laptop", 5);

		////////////////////////////////////

		// customer 2
		requestMap2.put("Kingston pendrive", 100);
		requestMap2.put("Dell Laptop", 1);

		reqList1.add(requestMap);

		reqList1.add(requestMap2);

		List<Inventory> invList = new ArrayList<Inventory>();

		invList.add(new Inventory(reqList1));
		invList.add(new Inventory(reqList2));

		List<Future<List<Map<String, String>>>> futureResp = service.invokeAll(invList);

		System.out.println("Done");
	}

}
