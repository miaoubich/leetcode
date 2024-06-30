package net.miaoubich.leetcode;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// Sort the chars of a string from the most frequent to the least frequent 
// and if 2 or more chars have the same frequency sort them in Desc order
public class StringCharactersByFrequency {

	public static void main(String[] args) {
        String input = "linagonina";//niaolg

        System.out.println(stringFrequency(input));
    }
	
	public static String stringFrequency(String s) {
		StringBuilder sb = new StringBuilder();
		Map<Character, Long> map = s.chars().asDoubleStream().mapToObj(c->(char)c)
		                          .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		map.forEach((k,v)->System.out.println(k+", "+v));
		
		List<Character> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys, (a, b)->{
			int diff = Long.compare(map.get(b), map.get(a));
			
			if(diff == 0) {
				diff = Character.compare(b, a);
			}
			return diff;
		});
		for(int i=0; i<keys.size(); i++) {
			sb.append(keys.get(i));
		}
		return sb.toString();
	}

	public static void stringFrequency1(String input) {
        Map<Character, Integer> map = new HashMap<>();
        
        // Count the frequency of each character
        for(char c : input.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //or
        Map<Character, Long> map1 = input.chars().asLongStream().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Sort the characters by frequency
        List<Character> charsList = new ArrayList<>(map.keySet());
        Collections.sort(charsList, (a, b) -> {
        	int freqCompare = Integer.compare(map.get(b), map.get(a));
//            int freqCompare = map.get(b).compareTo(map.get(a));
         
            if (freqCompare == 0)
                	return Character.compare(b, a); // Sort in descending order if frequencies are the same
            return freqCompare;
        });

        for (char c : charsList) {
            System.out.print(c);
        }
	}
	
}
