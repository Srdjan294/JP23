package zadaci;

import java.util.Scanner;

public class Zadatak4 {
	
	//Kreirati program koji unosi dvije matrice 4x4 te ispisuje njihov zbroj
	
	public static void main(String[] args) {
		
		int p = 4, q = 4, m = 4, n = 4;
		Scanner s = new Scanner(System.in);
		
		
		
		if(p == m && q == n) {
			int a[][] = new int[p][q];
			int b[][] = new int[m][n];
			int c[][] = new int[m][n];
			
			System.out.println("Unesi sve elemente 1. matrice: ");
			for(int i = 0; i < p; i++) {
				for(int j = 0; j < q; j++) {
					a[i][j] = s.nextInt();				
				}
			}
			System.out.println("Unesi sve elemente 2. matrice: ");
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					b[i][j] = s.nextInt();
				}
			}
			System.out.println("1. matrica: ");
			for(int i = 0; i < p; i++) {
				for(int j = 0; j < q; j++) {
					System.out.printf("%3d",a[i][j]);
				}
				System.out.println("");
			}
			System.out.println("2. matrica: ");
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					System.out.printf("%3d",b[i][j]);
				}
				System.out.println("");
			}
			
			for(int i = 0; i < p; i++) {
				for(int j = 0; j < n; j++) {
					for(int k = 0; k < q; k++) {
						c[i][j] = a[i][j] + b[i][j];
					}
				}
			}
			System.out.println("Zbroj matrica: ");
			for(int i = 0; i < p; i++) {
				for(int j = 0; j < n; j++) {
					System.out.printf("%3d",c[i][j]);
				}
				System.out.println("");
			}
			
		}
		else {
			System.out.println("Zbrajanje nije moguæe");
		}
		
		s.close();
	}

}
