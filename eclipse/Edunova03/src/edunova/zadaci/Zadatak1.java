package edunova.zadaci;

public class Zadatak1 {

	//Program ispisuje sve brojeve od 20 do 200
	
	// program ispisuje sve parne brojeve od 1 do 57
	
	//program ispisuje sve brojeve od 100 do 1
	
	//program ispisuje sve neparne brojeve od 100 do 21
	
	public static void main(String[] args) {
		
		for(int i=20; i<=200; i++) {
			System.out.printf("%d ", i);
		}
		
		System.out.println("\n");
		
		for(int i=1; i<57; i++) {
			if(i%2==0) {
				System.out.printf("%d ", i);
			}
		}
		
		System.out.println("\n");
		
		for(int i=100; i>=1; i--) {
			System.out.printf("%d ", i);
		}
		
		System.out.println("\n");
		
		for(int i=100; i>=21; i--) {
			if(i%2==1) {
				System.out.printf("%d ", i);
			}
		}
	}
}
