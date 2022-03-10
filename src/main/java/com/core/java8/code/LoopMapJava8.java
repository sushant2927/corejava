package com.core.java8.code;

import java.util.HashMap;
import java.util.Map;

public class LoopMapJava8 {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		map.put("A", 10);
		map.put("B", 20);
		map.put("C", 30);
		map.put("D", 40);
		map.put("E", 50);
		map.put("F", 60);

		map.forEach((k, v) -> System.out.println(k + "  " + v));

		System.out.println("DOn't print the null key n value");

		Map<String, Integer> map2 = new HashMap<>();
		map2.put("A", 10);
		map2.put("B", 20);
		map2.put("C", 30);
		map2.put(null, 40);
		map2.put("E", null);
		map2.put("F", 60);

		map2.forEach((k, v) -> {

			if (k != null && v!=null) {

				System.out.println(k + "     " + v);
			}
		}

		);

	}
}