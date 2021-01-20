package edunova.zadaci;

import java.util.Scanner;

public class Zadatak02 {
	
	//Program unosi 2 broja od korisnika
	//Program ispisuje razliku kao rezultat izvoðenja
	//metode koja prima dva paramatra i tipa je float
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Unesi 2 broja");
		
		float a = input.nextFloat();
		float b = input.nextFloat();
		
		System.out.println(Zadatak02.razlika(a,b));
		
		input.close();
	}
	
	public static float razlika(float a, float b) {
		return a-b;
	}

}
