package edunova;

public class E02_dowhile {
	
	public static void main(String[] args) {
		// izvesti æe se minimalno jednom
		int i=0;
		do {
			System.out.println("OK");
		}while(i>0);
		
		// beskonaèni while
		do {
			break;
		}while(true);
		
		// do while se koristi kada se nešto MORA barej jednom odraditi
	}

}
