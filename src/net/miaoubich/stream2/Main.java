package net.miaoubich.stream2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		String[] animals = { "cat", "mice", "cat", "dog", "tiger", "cat", "mice", "tiger", "mice", "cat", "lion",
				"elephant" };
		String[] animals2 = { "cat", "pat", "dog", "Girafa", "patterfly" };
		String[] fruits = { "Orange", "dattes", "Apple", "banana", "kiwi", "apricot", "avocado" };

//		1. Calculate the frequency of each word and sort them from the most frequent to the less frequent,
//         if two words have the same frequency sort them in descending order
		Map<String, Long> map = Arrays.stream(animals)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		System.out.println(map);
		List<String> result = new ArrayList<>(map.keySet());
		Collections.sort(result, (a, b) -> {
			int freq = Long.compare(map.get(b), map.get(a));
			if (freq == 0)
				return b.compareTo(a);
			return freq;
		});
//		System.out.println(result);
		// Or
		Map<String, Long> mapFreq = new HashMap<>();
		for (String a : animals) {
			mapFreq.put(a, mapFreq.getOrDefault(a, (long) 0) + 1);
		}
//		System.out.println(mapFreq);
		List<String> result2 = new ArrayList<>(map.keySet());
		Collections.sort(result2, (a, b) -> {
			int freq = Long.compare(map.get(b), map.get(a));
			if (freq == 0)
				return b.compareTo(a);
			return freq;
		});
//		System.out.println(result2);

//		2. Write a program to find the longest string in a list of strings using streams.
		String longestString = Arrays.stream(animals).max(Comparator.comparingInt(String::length)).get();
		// or
		String longestString2 = Arrays.stream(animals).max((s1, s2) -> Integer.compare(s1.length(), s2.length())).get();
//		System.out.println(longestString);

//		3. Remove duplicates and keep the words in the descending order using streams.
		List<String> descendSorted = Arrays.stream(animals).distinct().sorted((a1, a2) -> a2.compareTo(a1))
				.collect(Collectors.toList());
//		System.out.println(descendSorted);

//	    4. Write a program to find the average of a list of doubles using streams
		List<Double> doubles = Arrays.asList(10.5, 9.50, 14.66, 15.34, 2.12, 7.88);
		double sum = doubles.stream().mapToDouble(Double::doubleValue).sum();
		double avg = doubles.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
//		System.out.println("Sum: " + sum + "\navg: " + avg);

//		5. Merge two lists of integers and remove duplicates using streams.
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> list2 = Arrays.asList(5, 6, 7, 8, 9, 10);
		List<Integer> list = Stream.concat(list1.stream(), list2.stream()).distinct().toList();
//		System.out.println(list);

//		6. Given a list of strings, concatenate them into a single string using streams.
		String bigWord = Arrays.stream(animals).reduce("", (s1, s2) -> s1.concat(s2));
//		System.out.println(bigWord);
//		or
		String bigWord2 = Arrays.stream(animals).collect(Collectors.joining());
//		System.out.println(bigWord2);

//		7. Write a program to find the first non-repeating character in a string using streams.
		String word = "crocodile";
//		System.out.println(returnFirstNonRepeatingChar(word));
		Character firstNonRepeatingChar = word.chars().asLongStream().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(en -> en.getValue() == 1L).map(Map.Entry::getKey).findFirst().get();
//		System.out.println(firstNonRepeatingChar);

//		8. Given a list of strings, replace a specific character with another char using streams.
		char charTobeRemoved = 'a';
		char newChar = 'i';
		List<String> wordsWithoutA = Arrays.stream(animals2).map(w -> w.replace(charTobeRemoved, newChar)).toList();
//        wordsWithoutA.forEach(System.out::println);

//      9. Given a list of strings, remove all strings that contain a specific character using streams.
		char c = 'a';
		List<String> newList = Arrays.stream(animals2).filter(w -> !w.contains(String.valueOf(c)))
				.collect(Collectors.toList());
//        newList.forEach(System.out::println);

//      10. Given a list of integers, partition them into two groups: odd and even, using streams.
		Map<Boolean, List<Integer>> oddEvenNumbers = list.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
//        System.out.println(oddEvenNumbers);

//      11. Given an array of integers, find the kth largest element.
		int k = 3;
		int kThLargestNumber = list1.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).skip(k - 1)
				.findFirst().get();
		// or
		int kThLargestNumber1 = list1.stream().sorted(Comparator.reverseOrder()).skip(k - 1).findFirst().get();
//        System.out.println(kThLargestNumber1);

//      12. Write a program to perform cube on list elements and filter numbers greater than 50
		List<Double> cubeList = list1.stream().map(n -> Math.pow(n, 3)).filter(n -> n > 50).toList();
//        System.out.println(cubeList);

//      13. Given a list of strings, find the count of strings starting with a vowels.
		char[] vowels = { 'a', 'e', 'r', 'o', 'u' };
		long startsWithVowel = Arrays.stream(fruits).filter(f -> {
			for (char c1 : vowels)
				if (f.toLowerCase().startsWith(String.valueOf(c1)))
					return true;
			return false;
		}).count();
//		System.out.println(startsWithVowel);
		
//		14.Given a list of strings, find the longest palindrome string.
		List<String> things = List.of("level", "hello", "radar", "world", "madam", "java", "Malayalam");
		String longestPalindrom = things.stream().filter(s-> new StringBuilder(s).reverse().toString().equalsIgnoreCase(s))
				  .max(Comparator.comparing(String::length)).get();
//		System.out.println(longestPalindrom);
		
//		15. Given a list of integers, find the product of all non-negative integers.
		List<Integer> ints = List.of(-5,3,-6,2,3,-1,4);
		Long product = ints.stream().filter(n->n>0).reduce(1, (a,b)->a*b).longValue();
		System.out.println(product);
	}

	public static Character returnFirstNonRepeatingChar(String word) {
		Map<Character, Long> map2 = word.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println(map2);
		for (Map.Entry<Character, Long> en : map2.entrySet()) {
			if (en.getValue() == 1)
				return en.getKey();
		}
		return '\0';
	}
	
}
