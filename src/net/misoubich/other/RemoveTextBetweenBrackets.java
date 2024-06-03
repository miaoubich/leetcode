package net.misoubich.other;

public class RemoveTextBetweenBrackets {

	public static void main(String[] args) {
		String test="Lina Gon(hjds)ina, (but)loves Paw Pat(dsa)rol";
        System.out.println(removeTextBetweenBrackets(test));

	}

	public static String removeTextBetweenBrackets(String str) {
		StringBuilder sb = new StringBuilder();
		boolean braketActive = false;
		char[] c = str.toCharArray();
		
		for(int i=0; i<c.length; i++) {
			if(c[i] == '(')
				braketActive = true;
			else if(c[i] == ')') {
				braketActive = false;
				i++;
			}
			if(braketActive == false)
				sb.append(c[i]);
		}
		return sb.toString();
	}
}
