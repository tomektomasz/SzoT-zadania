package Example;

import java.util.Arrays;

public class Anagram {
	public static void main(String[] args) {
		anag("finder","friend");
	}

	private static void anag(String an1, String an2) {
		char[] ch1= an1.toCharArray();
		char[] ch2= an2.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		if(Arrays.equals(ch1,ch2)) System.out.println("true");
		else System.out.println("false");
	}
}
