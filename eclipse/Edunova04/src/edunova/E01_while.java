package edunova;

public class E01_while {
	
	public static void main(String[] args) {
		
		// sve dok je istina
		
		int i=0;
		while(i<10) {
			System.out.println(i);
			i++;
		}
		
		// while radi s boolean tipom podatke
		i=0;
		boolean ostaniUpetlji=i<10;
		while(ostaniUpetlji) {
			System.out.println(i);
			ostaniUpetlji=++i<10;
		}
		
		i=0;
		while(i<10) {
			System.out.println(i++);
		}
		
		
		//provjerava uvjet na poèetku
		//postoji moguænost da nikada neæeš uæi u while
		
		i=20;
		while(i<10) {
			System.out.println("Ovo neæe ispisati");
		}
		
		//beskonaèna petlja
		while(true) {
			if(i++==20) {
				continue;
			}
			if(i==21) {
				break;
			}
		}
		
		i=0;
		int j=0;
		while(i<10) {
			while(j<10) {
				j++;
			}
			i++;
		}
		
	}

}
