package projectEuler;

public class Problem004 {
	
//	A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 � 99.
//
//			Find the largest palindrome made from the product of two 3-digit numbers.
	 

	public static void main(String[] args) {
		
		int value = 0;
		for(int i = 100; i <= 999; i++) {
			for(int j = 100; j <= 999; j++) {
				int value1 = i*j;
				StringBuilder sb1 = new StringBuilder(""+value1);
				String sb2 = "" + value1;
				sb1.reverse();
				if(sb2.equals(sb1.toString()) && value<value1) {
					value=value1;
				}
			}
		}
		System.out.println(value);
	}

}
