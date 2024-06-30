package net.miaoubich.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringCharactersByFrequency {

	public static void main(String[] args) {
        String input = "linagonina";//anmwod

        stringFrequency(input);
    }

	public static void stringFrequency(String input) {
        Map<Character, Integer> map = new HashMap<>();
        
        // Count the frequency of each character
        for(char c : input.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //or
        Map<Character, Long> map1 = input.chars().asDoubleStream().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

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
