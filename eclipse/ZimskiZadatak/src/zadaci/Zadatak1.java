package zadaci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zadatak1 {
	
	// Kreirati program koji unosi 24 broja, ispisuje njihov zbroj, najmanji i  najveæi uneseni broj.
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader ulaz = new BufferedReader (new InputStreamReader(System.in));
		
		int i, s=0, najmanji, najveci;
		int[] polje = new int [24];
		
		System.out.println("Unesi 24 broja: ");
		
		for(i=0;i<24;i++){
			polje[i]=Integer.parseInt(ulaz.readLine());
			s += polje[i];
		}
		System.out.println(s);
		
		najmanji = polje[0];
		
		for(i=0;i<24;i++) {
			if(polje[i]<najmanji) {
				najmanji = polje[i];
			}
		}
		System.out.println(najmanji);
		
		najveci = polje[0];
		
		for(i=0;i<24;i++) {
			if(polje[i]>najveci) {
				najveci = polje[i];
			}
		}
		System.out.println(najveci);
		
		
	}
}