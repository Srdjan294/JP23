package edunova.zadaci;

import javax.swing.JOptionPane;

public class Zadatak01 {
	
	//Upogonite smisleno svih razlièitih naziva poziva metode
	//JOptionPane.showInputDialog
	
	public static void main(String[] args) {
		
		String message = "Ovo je poruka";
//		String answer = JOptionPane.showInputDialog(message);
//		System.out.println(answer);
		
//		String answer = JOptionPane.showInputDialog(null, message);
//		System.out.println(answer);
		
		int initialSelectionValue = 1;
//		JOptionPane.showInputDialog(message, initialSelectionValue);
		
//		//JOptionPane.showInputDialog(parentComponent, message, initialSelectionValue);
//		JOptionPane.showInputDialog(null, message, initialSelectionValue);
		
		String title = "naziv";
		
//		//JOptionPane.showInputDialog(parentComponent, message, title, messageType);
//		JOptionPane.showInputDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
		
		
		String[] answers = {"first","second"};
		
		
		//JOptionPane.showInputDialog(parentComponent, message, title, messageType, icon, selectionValues, initialSelectionValue)
		JOptionPane.showInputDialog(null, message, title, JOptionPane.ERROR_MESSAGE, JOptionPane.CANCEL_OPTION, answers , initialSelectionValue);
	}

}
