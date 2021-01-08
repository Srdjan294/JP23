package projectEuler;

public class Problem003 {
	
//	The prime factors of 13195 are 5, 7, 13 and 29.
//
//	What is the largest prime factor of the number 600851475143 ?
	
	// A function to print all prime numbers of a given number n
	public static void primeFactors(long n) {
		
		// Print the number of 2s that devide n
		while(n % 2 == 0) {
			System.out.println(2 + " ");
			n /= 2;
		}
		
		// n must be odd at this point. So we can skip one element (Note i = i + 2)
		for(int i = 3; i <= Math.sqrt(n); i += 2) {
			// While i divides n, print i and divide n
			while(n % i == 0) {
				System.out.println(i + " ");
				n /= i;
			}
		}
		
		// This condition is to handle the case when n is a prime number greater than 2
		if(n > 2) {
			System.out.println(n);
		}
			
	}
	
	
	public static void main(String[] args) {
		
		long n = 600851475143L;
		primeFactors(n);
		
	}
	

}
