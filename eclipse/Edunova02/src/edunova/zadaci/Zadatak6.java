package edunova.zadaci;

import javax.swing.JOptionPane;

public class Zadatak6 {
	
	// Korisnik unosi 2 broja. 
	// Ukoliko je produkt ta dva broja paran broj
	// ispisuje razliku unesinih brojeva
	// inaèe ispisuje cijeli dio kvocjenta prvog i drugog broja
	
	public static void main(String[] args) {
		
		String prviBroj= JOptionPane.showInputDialog("Unesi 1. broj");
		String drugiBroj= JOptionPane.showInputDialog("Unesi 2. broj");
		
		int a = Integer.parseInt(prviBroj);
		int b = Integer.parseInt(drugiBroj);
		
		
		if((a*b)%2==0) {
			System.out.println(a>b ? a-b : b-a );
		}else {
			System.out.println(a>b ? (int)a/b : (int)b/a);
		}
		
	}

}
