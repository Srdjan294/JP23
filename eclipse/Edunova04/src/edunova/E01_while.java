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
		
		
		//provjerava uvjet na po�etku
		//postoji mogu�nost da nikada ne�e� u�i u while
		
		i=20;
		while(i<10) {
			System.out.println("Ovo ne�e ispisati");
		}
		
		//beskona�na petlja
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
