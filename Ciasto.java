package Example;

public class Ciasto {
	public static void main(String[] args) {
		System.out.println(Boolean.toString(podzielenie(7,2,3)));
	}

	private static boolean podzielenie(int i, int j, int k) {
		if(j*k<i) return true;
		else return false;
	}
	
}
