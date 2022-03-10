package com.core.java.prac;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NoRepeatingElementJava8 {

	public static void main(String[] args) {

		Integer arr[] = { 1, 2, 3, 1, 4, 2, 3 };

		List<Integer> numList = Arrays.asList(arr);

		numList.stream().filter(S -> Collections.frequency(numList, S) == 1).forEach(System.out::println);

		Arrays.stream(arr).filter(s -> Collections.frequency(Arrays.asList(arr), s) == 1).forEach(System.out::println);

		String arrString[] = { "a", "b", "c", "d", "a", "b" };

		List<String> charList = Arrays.asList(arrString);

		charList.stream().filter(s -> Collections.frequency(charList, s) == 1).forEach(System.out::println);

	}
}
