package Example;

public class FizzBuzz {
	public static void main(String[] args) {
		potega(16);
	}

	private static void potega(int n) {
		//System.out.println("asfaf");
		for(int i=1;i<=n; i++) {
			if(i%3==0&&i%5==0) System.out.println("FizzBuzz");
			else if(i%3==0) System.out.println("Fizz");
			else if(i%5==0) System.out.println("Buzz");
			else System.out.println(i);			
		}
		
	}
}
