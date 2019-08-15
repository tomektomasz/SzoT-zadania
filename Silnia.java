package Example;

public class Silnia {
	public static void main(String[] args) {
		System.out.println(silnia(5));
	}

	private static int silnia(int i) {
		if(i>1)	return silnia(i-1)*i;
		else return 1;
		
	}
	
}
