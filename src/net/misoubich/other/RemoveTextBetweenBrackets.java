package net.misoubich.other;

public class RemoveTextBetweenBrackets {

	public static void main(String[] args) {
		String test1 = "hellow((world(this)hey)text)print(web)me";
		String test2 = "My baby L(df)ina (dd)likes baby(dsd) sh(dskd)ar(dskj)k!";
		System.out.println(removeTextBetweenBrackets(test1) + "\n" + removeTextBetweenBrackets(test2));

	}

	public static String removeTextBetweenBrackets(String str) {
		StringBuilder sb = new StringBuilder();
		boolean braketActive = false;
		char[] c = str.toCharArray();
		int counter = 0;

		for (int i = 0; i < c.length; i++) {
			if (c[i] == '(') {
				braketActive = true;
				counter += 1;
			} else if (c[i] == ')') {
				braketActive = false;
				counter -= 1;
				i++;
			}
			if (braketActive == false && counter == 0)
				sb.append(c[i]);
		}
		return sb.toString();
	}
}
