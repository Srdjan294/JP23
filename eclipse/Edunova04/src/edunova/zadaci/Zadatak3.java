package edunova.zadaci;

public class Zadatak3 {
	
	public static void main(String[] args) {
		
		//ugnježðivanje zadatak: Ispisati tablicu množenja
		// 5 x 5 s while petljam
		
		int i = 1;
		
		while(i<=5) {
			int j = 1;
			while(j<=5) {
				System.out.print(i*j+"\t");
				j++;
			}
			i++;
			System.out.println();
		}
	}

}
