package edunova.crud;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Pomocno {
	
	private static final Scanner ulaz = new Scanner(System.in);
	private static final SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
	
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
	
	public static int ucitajCijeliBroj(String poruka,int min,int max) {
		
		int i;
		
		while(true) {
			System.out.print(poruka + ": ");
			try {
				i = Integer.parseInt(ulaz.nextLine());
				if(i<min || i>max) {
					System.out.println("Broj nije u danom rasponu (" + min + "-" + max + ")");
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
	
	public static Date ucitajDatum(String poruka) {
		
		while(true) {
			try {
				System.out.println(poruka);
				return df.parse(ulaz.nextLine());
			} catch (Exception e) {
				System.out.println("Datum nije u dobrom formatu");
				System.out.println("Primjer unosa: " + df.format(new Date()));
			}
		}
	}


}
