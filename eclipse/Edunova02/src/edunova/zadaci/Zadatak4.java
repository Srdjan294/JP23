package edunova.zadaci;

import javax.swing.JOptionPane;

public class Zadatak4 {

	// Korisnik unosi 3 cijela broja 
	// program ispisuje najveæi
	
	public static void main(String[] args) {
		
		String prviBroj= JOptionPane.showInputDialog("Unesi 1. broj");
		String drugiBroj= JOptionPane.showInputDialog("Unesi 2. broj");
		String treciBroj= JOptionPane.showInputDialog("Unesi 3. broj");
		
		int a = Integer.parseInt(prviBroj);
		int b = Integer.parseInt(drugiBroj);
		int c = Integer.parseInt(treciBroj);
		
		if(a>=b && a>=c) {
			System.out.println(a);
		}
		if(b>=a && b>=c) {
			System.out.println(b);
		} 
		if(c>=a && c>=b){
			System.out.println(c);
		}
	}
}
