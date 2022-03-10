package com.core.java.prac;

import java.util.HashMap;
import java.util.concurrent.Callable;

public class HostCallNode implements Callable<HashMap<String, String>> {

	String userId;

	HashMap<String, String> map;

	public HostCallNode() {

	}

	public HostCallNode(String userId, HashMap<String, String> map) {
		super();
		this.userId = userId;
		this.map = map;
	}

	public static HashMap HostCall(String userId) {

		HashMap<String, String> hashMap = new HashMap<String, String>();

		if (userId.equalsIgnoreCase("PMR")) {

			/* throw new NullPointerException(); */

			hashMap.put("Cust_Name", "Free Guy");
			hashMap.put("Cust_Type", "PMR");

		}

		else if (userId.equalsIgnoreCase("ADV")) {
			hashMap.put("Cust_Name", "David Smith");
			hashMap.put("Cust_Type", "ADV");
		}

		return hashMap;

	}

	@Override
	public HashMap<String, String> call() throws Exception {

		HostCallNode node = new HostCallNode();

		HashMap<String, String> respHashMap = node.HostCall(userId);
		return respHashMap;
	}

}
