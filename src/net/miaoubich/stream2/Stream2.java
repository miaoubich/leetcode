package net.miaoubich.stream2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Stream2 {

	public static void main(String[] args) {
		String[] animals = { "cat", "mice", "cat", "dog", "tiger", "cat", "mice", "tiger", "mice", "cat", "lion",
				"elephant" };
		String[] animals2 = { "cat", "pat", "dog", "Girafa", "patterfly" };
		String[] fruits = { "Orange", "dattes", "Apple", "banana", "kiwi", "apricot", "avocado" };

//		stringFrequencyJava8(animals).entrySet().forEach(System.out::println);
//		stringFrequencyJava8(animals).forEach(a->System.out.printf(a + ", "));

//		System.out.println(stringFrequency(animals));

		stringFrequencyJava8("linagonina");
	}

//	1. Sort the animals from the highest frequent to the lowest frequent in java8
	public static Set<String> stringFrequencyJava8(String[] animals) {
		Map<String, Long> frequencyMap = Arrays.stream(animals)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		frequencyMap.entrySet().forEach(System.out::println);
		return frequencyMap.keySet();
	}

//	2. 
	public static List<String> stringFrequency(String[] animals) {
		Map<String, Integer> frequencyMap = new HashMap<>();
		for (String animal : animals)
			frequencyMap.put(animal, frequencyMap.getOrDefault(animal, 0) + 1);

		List<String> keys = new ArrayList<>(frequencyMap.keySet());
		System.out.println(frequencyMap);

		Collections.sort(keys, (a, b) -> {
			int freq = frequencyMap.get(b).compareTo(frequencyMap.get(a));// sort from the highest freq to the lowest

			if (freq == 0)// if the frequency of Strings is equals, sort them in desc order
				freq = b.compareTo(a);

			return freq;
		});

		return keys;
	}

//	2. Sort the animals from the least frequent to the highest frequent
	public static List<String> sortFromLowestFreqToHighest(String[] animals) {
		Map<String, Long> freqMap = Arrays.stream(animals)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		return freqMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).map(en -> en.getKey()).toList();
	}

//	3. Calculate the frequency of characters within a string, sort them 
//	from the most freq to the least freq, and if some chars are equal in frequency sort them in desc order
	public static void stringFrequencyJava8(String str) {
		Map<Character, Long> freqMap = str.chars().asDoubleStream().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println(freqMap);
		List<Character> keys = new ArrayList<>(freqMap.keySet());
		Collections.sort(keys, (a, b) -> {
			int freq = Long.compare(freqMap.get(b), freqMap.get(a));
			if (freq == 0)
				freq = Character.compare(b, a);
			return freq;
		});
		
		StringBuilder sb = new StringBuilder();
		for(char c: keys)
			sb.append(c);
		
		System.out.println(sb.toString());
	}

}
