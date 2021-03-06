package edunova;

import javax.swing.JOptionPane;

import static edunova.E05MetodeV4.slucajniBroj;

/**
 * U�enje metoda
 * @author Filipovi� Sr�an
 * 2021
 */
public class E01Metode {
	
	static int naRaziniKlase;
	
	/**
	 * POTPIS METODE
	 * public - na�in pristupa
	 * static - mo�e se izvoditi bez kreiranja instance
	 * void - tip (koji metoda vra�a)
	 * naziv metode (main)
	 * (u zagradi) lista parametara koje metoda prima. Parametri su odvojeni zarezom 
	 * @param args
	 */
	public static void main(String[] parametarMetode) {
		int unutarMetode=0;
		System.out.println("Hello");
		
		E02MetodaV1.odradiPosao();
		E02MetodaV1.packageScope();
		//E02MetodaV1.nijeStatic(); nije dostupno jer nije stati�na metoda
		
		
		E03MetodeV2.ispisi(2, 3);
		//int i = E03MetodeV2.ispisi('c'); // ne ide
		//System.out.println(E03MetodeV2.ispisi('c'); // ne ide
		
		E04MetodeV3.zbroji(3,3); // nije sintaksna gre�ka ali nije dobra praksa
		
		int rez = E04MetodeV3.zbroji(7,6);
		System.out.println(rez);
		
		var r = E04MetodeV3.zbroji(7,6);
		
		System.out.println(r);
		
		System.out.println(E04MetodeV3.zbroji(2,4));
		 
		//uobi�ajnije je
		System.out.println(apsolutnaVrijednost(-2));
		
		//mogu�e
		System.out.println(E01Metode.apsolutnaVrijednost(1));
		
		System.out.println(slucajniBroj());
		
	}
	
	static int apsolutnaVrijednost(int i) {
		return i*-1;
	}
	
	static boolean isPrime(int number, int prvaVerzija) {
		boolean prime = true;
		
		for(int i = 2; i < number; i++) {
			if(number%i == 0) {
				prime = false;
			}
		}
		
		return prime;
	}
	
	static boolean isPrime(int number, char drugaVerzija) {
		boolean prime = true;
		
		for(int i = 2; i < number; i++) {
			if(number%i == 0) {
				prime = false;
				break;
			}
		}
		
		return prime;
	}
	
	static boolean isPrime(int number, boolean najboljaVerzija) {
		if(number<2) {
			return false;
		}
		for(int i = 2; i < number; i++) {
			if(number%i == 0) {
				return false; // short curcuiting
			}
		}
		
		return true;
	}

}
