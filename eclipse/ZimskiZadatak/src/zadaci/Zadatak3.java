package zadaci;

import java.util.Scanner;

public class Zadatak3 {
	
	// Kreirati program koji za dva unesena broja ispisuje sve prim/prosti/prime brojeve izmeðu njih.
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Unesi prvi broj: ");
		int prvi = s.nextInt();
		
		System.out.println("Unesi drugi broj: ");
		int drugi = s.nextInt();
		
		System.out.println("Prosti brojevi izmeðu "+prvi+" i "+drugi);
		
		for(int i = prvi; i <= drugi; i++) {
			if(jeProst(i)) {
				System.out.println(i);
			}
		}
		s.close();
		
	}
		
		public static boolean jeProst(int n) {
			if(n <= 1) {
				return false;
			}
			for(int i = 2; i <= Math.sqrt(n); i++) {
				if(n%i == 0) {
					return false;
				}
			}
			return true;
		}
	}


