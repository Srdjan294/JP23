package zadaci;

public class Zadatak2 {
	
	// Kreirati program koji ispisuje tablicu množenja 15x15 lijepo formatiranu
	
	public static void main(String[] args) {
		
		int i, j;
		
		for(i=1; i<=15; i++) {
			for(j=1; j<=15; j++) {
				System.out.printf("%4d",i*j);
			}
			System.out.println();
		}
	}

}
