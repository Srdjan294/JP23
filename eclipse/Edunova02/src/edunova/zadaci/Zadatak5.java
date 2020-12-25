package edunova.zadaci;

import javax.swing.JOptionPane;

public class Zadatak5 {

	// Korisnik unosi cijeli broj
	// Ako je paran broj unesen ispiši Osijek
	// Ako je neparan broj unesen ispiši Zagreb
	
	// koristiti inline if
	
	public static void main(String[] args) {
		
		String Broj= JOptionPane.showInputDialog("Unesi cijeli broj");
		
		int a = Integer.parseInt(Broj);
		
		System.out.println(a%2==0 ? "Osijek" : "Zagreb");
		
	}

}
