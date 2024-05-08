package net.misoubich.leetcode;

public class IntegerToRoman {

	public static void main(String[] args) {
		System.out.println(intToRoman1(1900));
	}

	/*
	 * Time Complexity: 
	 *  - since the the number of iterations is fixed
	 * which is 12 and does not depend on the size of the input then
	 * the overall time complexity of this algorithm is O(1)
	 * Space Complexity:
	 *  - Is O(1) because the StringBuilder (sb) is proportional to 
	 *  the length of the output string, which is determined by the 
	 *  input num. However, the maximum length of the output string 
	 *  is constant because Roman numerals have a limited set of characters.
	 * */
	public static String intToRoman(int num) {
		if (num < 1 || num > 3999) 
			return null;
		
		StringBuilder sb = new StringBuilder();
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 5, 4, 1 };
		String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "V", "IV", "I" };

		for (int i = 0; i < values.length; i++) {
			while (num >= values[i]) {
				num -= values[i];
				sb.append(symbols[i]);
			}
		}
		return sb.toString();
	}

	public static String intToRoman1(int num) {
		String M[] = { "", "M", "MM", "MMM" };
		String C[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String X[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String I[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
	}
}
