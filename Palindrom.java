package Example;

import java.util.Arrays;

public class Palindrom {
	public static void main(String[] args) {
		
		System.out.println(anag("  kajak ","k a  ja k"));
	}

	private static boolean anag(String an1, String an2) {
				
		char[] ch1= an1.replace(" ","").toCharArray();
		int sizeCh1 = ch1.length;
		char[] revCh1 = new char[sizeCh1];
		for(int i=0; i<sizeCh1;i++) {
			revCh1[sizeCh1-i-1]=ch1[i];
		}
		String revAn1 = new String(revCh1);
		
		an2=an2.replace(" ", "");
		
		if(revAn1.equals(an2)) return true;
		else return false;	
	}

}

//sprawdzenie czy dany wyraz lub zdanie czytane od przodu lub od tyłu są takie same
