package edunova.zadaci;

import javax.swing.JOptionPane;

public class Zadatak5 {

	// Korisnik unosi cijeli broj
	// Ako je paran broj unesen ispi�i Osijek
	// Ako je neparan broj unesen ispi�i Zagreb
	
	// koristiti inline if
	
	public static void main(String[] args) {
		
		String Broj= JOptionPane.showInputDialog("Unesi cijeli broj");
		
		int a = Integer.parseInt(Broj);
		
		System.out.println(a%2==0 ? "Osijek" : "Zagreb");
		
	}

}
