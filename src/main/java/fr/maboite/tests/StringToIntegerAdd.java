package fr.maboite.tests;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class StringToIntegerAdd {

	public int addSubStringIntegers(String stringNumbers) {
		List<String> words = Arrays.asList(stringNumbers.split(","));
		List<Integer> numbers= new ArrayList<>();
		
		for(String s: words) numbers.add(Integer.valueOf(s));
		
		Integer stringInInteger = numbers.stream().reduce(0, (subtotal, element) -> subtotal + element);
		
		return stringInInteger;
	}
}
