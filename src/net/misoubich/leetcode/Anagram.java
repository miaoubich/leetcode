package net.misoubich.leetcode;

import java.util.Map;
import java.util.stream.Collectors;

public class Anagram {

	public static void main(String[] args) {
		String s = "ali";
		String t = "lia";

		System.out.println(isAnagram(s, t));
	}

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		Map<Object, Long> sMap = s.chars().asLongStream().mapToObj(s1 -> (char) s1)
				.collect(Collectors.groupingBy(s1 -> s1, Collectors.counting()));
		Map<Object, Long> tMap = t.chars().asLongStream().mapToObj(t1 -> (char)t1)
				.collect(Collectors.groupingBy(t1 -> t1, Collectors.counting()));

		return sMap.equals(tMap);
	}
}