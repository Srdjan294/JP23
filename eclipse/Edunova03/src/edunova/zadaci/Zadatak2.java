package edunova.zadaci;

import java.util.Scanner;

public class Zadatak2 {
	
	// Program unosi dva cijela broja.
	// Program ispisuje OK ako je zbroj svih parnih brojeva
	// izmeðu ta dva cijela broja
	// veæi od 1000 
	
	public static void main(String[] args) {
		
		Scanner ulaz = new Scanner(System.in);
		
		System.out.print("Unesi 1. broj: ");
		int a = ulaz.nextInt();
		System.out.print("Unesi 2. broj: ");
		int b = ulaz.nextInt();
		
		int zbroj = 0;
		
		if(a<b) {
			for(int i=a; i<b; i++) {
				if(i%2==0) {
					zbroj += i;
				}
			}
		}
		
		if(b<a) {
			for(int i=b; i<a; i++) {
				if(i%2==0) {
					zbroj += i;
				}
			}
		}
		
		System.out.printf("Zbroj je: "+zbroj+". %s", zbroj>1000 ? "OK" : "Zbroj je manji od 1000");
		
		ulaz.close();
	}

}
