package edunova.zadaci;

import javax.swing.JOptionPane;

public class Zadatak7 {

	// Program od korisnika unosi slovo
	// u sluèaju slova A ispisuje 1. mjesto
	// pa sve do slova E gdje ispisuje 5. mjesto

	public static void main(String[] args) {
		
		char  slovo = JOptionPane.showInputDialog("Unesi slovo do A do E").charAt(0);
				
		switch(Character.toUpperCase(slovo)) {
		case 'A':
			System.out.println("1. mjesto");
			break;
		case 'B':
			System.out.println("2. mjesto");
			break;
		case 'C':
			System.out.println("3. mjesto");
			break;
		case 'D':
			System.out.println("4. mjesto");
			break;
		case 'E':
			System.out.println("5. mjesto");
			break;
		default:
			System.out.println("ostalo");
		}
		
	}
}
