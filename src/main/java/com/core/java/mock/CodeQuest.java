package com.core.java.mock;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CodeQuest {

	public static void main(String[] args) {
		String str = "zxyrabcznxyabcs";

		char[] ch = new char[str.length()];

		for (int i = 0; i < str.length(); i++) {
			ch[i] = str.charAt(i);

		}

		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();

		for (char c : ch) {

			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			}

			else {
				map.put(c, 1);
			}
		}
		
		
		System.out.println(map);

		
		  Map<Character, Integer> sortedMap =
		  map.entrySet().stream().sorted(Map.Entry.comparingByValue())
		  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (m1, m2) ->
		  m1, LinkedHashMap::new));
		  
		  for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()) { Character
		  key = entry.getKey(); Integer val = entry.getValue();
		  
		  System.out.println("key " + key); System.out.println("value " + val);
		  
		  break;
		  
		  }
		 
	}
}
