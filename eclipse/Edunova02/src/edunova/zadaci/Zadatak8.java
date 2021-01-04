package edunova.zadaci;

import javax.swing.JOptionPane;

public class Zadatak8 {

	// Napiši program koji odreðuje površinu trokuta zadanih stranica.
	
	public static void main(String[] args) {
		
		String stranicaa = JOptionPane.showInputDialog("Unesi duljinu stranice a");
		String stranicab = JOptionPane.showInputDialog("Unesi duljinu stranice b");
		String stranicac = JOptionPane.showInputDialog("Unesi duljinu stranice c");
		
		double a = Double.parseDouble(stranicaa);
		double b = Double.parseDouble(stranicab);
		double c = Double.parseDouble(stranicac);
		
		double s = (a + b + c) / 2;
		
		System.out.println( Math.sqrt(s * (s - a) * (s - b) * (s - c))); //Heronova formula za izraèun površine trokuta
	}

}
