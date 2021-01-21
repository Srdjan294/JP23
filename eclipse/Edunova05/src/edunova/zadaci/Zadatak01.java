package edunova.zadaci;

import javax.swing.JOptionPane;

public class Zadatak01 {
	
	//Upogonite smisleno svih razlièitih naziva poziva metode
	//JOptionPane.showInputDialog
	
	public static void main(String[] args) {
		
		//JOptionPane.showInputDialog(message);
		//JOptionPane.showInputDialog("Ovo je poruka");
		
		//JOptionPane.showInputDialog(parentComponent, message);
		//JOptionPane.showInputDialog(null, "Ovo je poruka");
		
		//JOptionPane.showInputDialog(message, initialSelectionValue);
		//JOptionPane.showInputDialog("Ovo je poruka", 1);
		
		//JOptionPane.showInputDialog(parentComponent, message, initialSelectionValue);
		//JOptionPane.showInputDialog(null, "Ovo je poruka", 1);
		
		//JOptionPane.showInputDialog(parentComponent, message, title, messageType);
		//JOptionPane.showInputDialog(null, "Ovo je poruka", "Naziv", JOptionPane.WARNING_MESSAGE);
		
		//JOptionPane.showInputDialog(parentComponent, message, title, messageType, icon, selectionValues, initialSelectionValue);
		String[] izbor = {"da", "ne"};
		JOptionPane.showInputDialog(null, "Ovo je izbor", "Naslov", JOptionPane.PLAIN_MESSAGE, null, izbor, izbor[1]);
	}

}
