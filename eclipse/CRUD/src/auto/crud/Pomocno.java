package auto.crud;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Pomocno {

	private static final Scanner ulaz = new Scanner(System.in);
	
	public static int ucitajCijeliBroj(String poruka) {
		
		int i;
		
		while(true) {
			System.out.print(poruka + ": ");
			try {
				i = Integer.parseInt(ulaz.nextLine());
				return i;
			} catch (Exception e) {
				System.out.println("Neispravan unos!");
			}
		}
	}
	
	public static int ucitajCijeliBroj(String poruka, int min, int max) {
		
		int i;
		
		while(true) {
			System.out.println(poruka + ": ");
			try {
				i = Integer.parseInt(ulaz.nextLine());
				if(i<min || i>max) {
					System.out.println("Broj nije u danom rasponu (" + min + "-" + max +")");
					continue;
				}
				return i;
			} catch (Exception e) {
				System.out.println("Neispravan unos!");
			}
		}
	}
	
	public static String ucitajString(String poruka) {
		
		String s;
		
		while(true) {
			System.out.println(poruka + ": ");
			s = ulaz.nextLine();
			if(s.trim().isEmpty()) {
				System.out.println("Obavezan unos!");
				continue;
			}
			return s;
		}
	}
	
	public static String ucitajDatum(String poruka) {
		
		while(true) {
			System.out.println(poruka + ": ");
			String datum = ulaz.nextLine();
			try {
				Date datumRodenja = new SimpleDateFormat("dd-MM-yyyy").parse(datum);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return datum;
		}
	}
}