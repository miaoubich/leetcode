package net.miaoubich.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {

	public static void main(String[] args) {
		String s = "alil";
		String t = "llia";

		Map<Character, Long> map = s.chars().asLongStream().mapToObj(s1 -> (char) s1)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
		System.out.println(isAnagram(s, t));
		
		isAnagram1(s, t);
	}

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		Map<Object, Long> sMap = s.chars().asLongStream().mapToObj(s1 -> (char) s1)
				.collect(Collectors.groupingBy(s1 -> s1, Collectors.counting()));
		Map<Object, Long> tMap = t.chars().asLongStream().mapToObj(t1 -> (char) t1)
				.collect(Collectors.groupingBy(t1 -> t1, Collectors.counting()));

		return sMap.equals(tMap);
	}
	
	public static void isAnagram1(String s1, String s2) {
		Map<Character, Long> map1 = s1.chars().asLongStream().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),
																									Collectors.counting()));
		Map<Character, Long> map2 = s2.chars().asLongStream().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),
																									Collectors.counting()));
		
		System.out.println("["+s1 + "], and [" + s2 + "] are anagram: " + ((map1.equals(map2))? "Yes": "No"));
	}

}
