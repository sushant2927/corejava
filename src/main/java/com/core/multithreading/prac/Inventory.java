package com.core.multithreading.prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class Inventory implements Callable<List<Map<String, String>>> {

	List<Map<String, Integer>> requestList;

	Map<String, String> responseHost;

	Map<String, String> response;
	List<Map<String, String>> responseList;

	public Inventory() {
	}

	public Inventory(List<Map<String, Integer>> requestList) {
		super();
		this.requestList = requestList;
	}

	@Override
	public List<Map<String, String>> call() throws Exception {

		Inventory inventory = new Inventory();

		for (Map<String, Integer> hashMap : requestList) {

			for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
				String key = entry.getKey();
				Integer val = entry.getValue();

				if (key.contains("Laptop")) {
					responseHost = inventory.laptopStockHost(key, val);
					response = new HashMap<String, String>();
				}

				else {
					responseHost = inventory.accessoriesStockHost(key, val);
					response = new HashMap<String, String>();
				}

			}

			if (responseList == null) {
				responseList = new ArrayList<Map<String, String>>();
			}

			responseList.add(responseHost);

			responseHost.clear();

		}

		return responseList;
	}

	private Map<String, String> accessoriesStockHost(String key, Integer val) {

		if (response == null) {
			response = new HashMap<String, String>();
		}

		if (val < 10) {
			response.put(key, "Unavailable");
		}

		else {
			if (key.equalsIgnoreCase("Kingston pendrive")) {
				response.put(key, "Available");

			}

			else if (key.equalsIgnoreCase("Asus VGA cable")) {
				response.put(key, "Available");

			}

			else if (key.equalsIgnoreCase("Lenovo keyboord cover")) {
				response.put(key, "Available");

			}

			else if (key.equalsIgnoreCase("HP mouse")) {
				response.put(key, "Available");

			}

			else {
				response.put(key, "Unavailable");
			}

		}

		return response;

	}

	private Map<String, String> laptopStockHost(String key, Integer val) {

		if (response == null) {
			response = new HashMap<String, String>();
		}
		if (val < 10) {
			response.put(key, "Unavailable");
		}

		else {
			if (key.equalsIgnoreCase("Dell Laptop")) {
				response.put(key, "Available");

			}

			else if (key.equalsIgnoreCase("Asus Laptop")) {
				response.put(key, "Available");

			}

			else if (key.equalsIgnoreCase("Lenovo Laptop")) {
				response.put(key, "Available");

			}

			else if (key.equalsIgnoreCase("HP Laptop")) {
				response.put(key, "Available");

			}

			else {
				response.put(key, "Unavailable");
			}

		}

		return response;
	}

}
