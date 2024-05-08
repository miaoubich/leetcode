package net.misoubich.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagram {

	public static void main(String[] args) {
		String[] list = { "eat", "tea", "tan", "ate", "nat", "bat" };

		System.out.println(groupAnagrams(list));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<>();

		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String sortedStr = String.valueOf(chars);
			if (!map.containsKey(sortedStr)) {
				map.put(sortedStr, new ArrayList<>());
			}
			map.get(sortedStr).add(str);
		}

		return new ArrayList<>(map.values());
	}

	public boolean anagram(String s, String t) {
		Map<Character, Long> sMap = s.chars().asLongStream().mapToObj(s1 -> (char) s1)
				.collect(Collectors.groupingBy(s1 -> s1, Collectors.counting()));
		Map<Character, Long> tMap = t.chars().asLongStream().mapToObj(t1 -> (char) t1)
				.collect(Collectors.groupingBy(t1 -> t1, Collectors.counting()));

		return sMap.equals(tMap);

	}
}
