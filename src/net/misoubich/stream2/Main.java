package net.misoubich.stream2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		String[] animals= {"cat", "mice", "cat", "dog", "tiger", "cat", "mice", "tiger", "mice", "cat", "lion", "elephant"};

//		1. Calculate the frequency of each word and sort them from the most frequent to the less frequent,
//         if two words have the same frequency sort them in descending order
		Map<String, Long> map = Arrays.stream(animals).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		System.out.println(map);
		List<String> result = new ArrayList<>(map.keySet());
		Collections.sort(result, (a,b)->{
			int freq = Long.compare(map.get(b), map.get(a));
			if(freq == 0)
				return b.compareTo(a);
			return freq;
		});
//		System.out.println(result);
		//Or
		Map<String, Long> mapFreq = new HashMap<>();
		for(String a: animals) {
			mapFreq.put(a, mapFreq.getOrDefault(a, (long) 0)+1);
		}
//		System.out.println(mapFreq);
		List<String> result2 = new ArrayList<>(map.keySet());
		Collections.sort(result2, (a,b)->{
			int freq = Long.compare(map.get(b), map.get(a));
			if(freq == 0)
				return b.compareTo(a);
			return freq;
		});
//		System.out.println(result2);
		
		
//		2. Write a program to find the longest string in a list of strings using streams.
		String longestString = Arrays.stream(animals).max(Comparator.comparingInt(String::length)).get();
		//or
		String longestString2 = Arrays.stream(animals).max((s1,s2)->Integer.compare(s1.length(),s2.length())).get();
//		System.out.println(longestString);
		
//		3. Remove duplicates and keep the words in the descending order using streams.
		List<String> descendSorted = Arrays.stream(animals).distinct()
														   .sorted((a1,a2)->a2.compareTo(a1))
														   .collect(Collectors.toList());
		System.out.println(descendSorted);
	
	}

}
