package projectEuler;

public class Problem006 {

	public static void main(String[] args) {
		
		int sum = 0;
		long sum2 = 0;
		for(int i = 1; i<=100; i++) {
			sum += Math.pow(i, 2);
		}
		
		System.out.println(sum);
		
		for(int i = 1; i <= 100; i++) {
			sum2 += i;
		}
		
		long x = (long)Math.pow(sum2, 2);
		System.out.println(x);
		
		System.out.println(25502500-338350);
	}
}
