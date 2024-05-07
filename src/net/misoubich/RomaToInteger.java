package net.misoubich;

import java.util.HashMap;
import java.util.Map;

public class RomaToInteger {

	public static void main(String[] args) {
		System.out.println(romanToInt("XIX"));
		System.out.println(romanToInt("XIXDLCD"));
		System.out.println(romanToInt("XIXLMCM"));
	}

	/*
	 * Time Complexity:
	 *  - The time complexity of this algorithm is O(n), 
	 *  where n is the length of the input string s.
	 * Space Complexity:
	 *  - Is O(1) because The space used by the HashMap (map) 
	 *  is fixed and independent of the input size. It only 
	 *  contains mappings for the Roman numeral characters, 
	 *  which are a constant set of characters.
	 * */
	public static int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int result = 0;
		if (1 <= s.length() && s.length() <= 15) {
			for (int i = 0; i < s.length(); i++) {
				if (map.containsKey(s.charAt(i))) {
					if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1)))
						result += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
					else
						result += map.get(s.charAt(i));
				}
			}
		}
		return result;
	}
}
