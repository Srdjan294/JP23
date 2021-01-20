package edunova.zadaci;

import java.util.Scanner;

public class Zadatak03 {
	
	// kreirajte metodu naziva ucitajBroj tipa int
	// koja od korisnika beskonaèno trai unos sve dok korisnik ne unese
	// broj veæi od nule
	// kada se to dogodi metoda tako unesenu vrijednost vrati 
	// onome koji ju je pozvao
	public static void main(String[] args) {
		unesiBroj();
	}
		
	
	public static int unesiBroj() {
		
		Scanner in = new Scanner(System.in);
		
		
		
		for(;;) {
			System.out.println("Unesi broj: ");
			int a = in.nextInt();
			if(a > 0) break;
		}
		
		return 0;
	}

}
