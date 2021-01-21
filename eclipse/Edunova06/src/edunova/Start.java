package edunova;

import edunova.zadaci.Osoba;

public class Start {
	
	public static void main(String[] args) {
		// objekt je instanca (pojavnost) klase
		// prvo se navede naziv klase pa ime varijable
		// Deklaracija objekta, inicijalna vrijednost je null
		E01Klasa nazivInstance;
		// nazivInstance: instance variable, varijabla
		//System.out.println(nazivInstance);
		
		// NullPointerException - èešæa greška
		//System.out.println(nazivInstance.getVisina());
		
		// konstruiranje
		nazivInstance = new E01Klasa();
		System.out.println(nazivInstance);
		
		// objekt nam služi da bi na njemu zapisivali odreðene vrijednosti
		nazivInstance.setVisina(2);
		
		// uèahurivanje
		//nazivInstance.visina = 2;
		
		// korištenje postavljene vrijednosti
		System.out.println(nazivInstance.getVisina());
		
		Pravokutnik[] pravokutnici = new Pravokutnik[2];
		/*
		Pravokutnik pravokutnik;
		
		pravokutnik = new Pravokutnik();
		pravokutnik.setNaziv("Prvi");
		pravokutnik.setDuzina(12);
		pravokutnik.setSirina(10);
		pravokutnici[0]=pravokutnik;
		
		pravokutnik = new Pravokutnik();
		pravokutnik.setNaziv("Drugi");
		pravokutnik.setDuzina(23);
		pravokutnik.setSirina(11);
		pravokutnici[1]=pravokutnik;
		*/
		
		pravokutnici[0] = kreiraj("Prvi",12,10);
		pravokutnici[1] = kreiraj("Drugi",23,11);
		
		
		for(Pravokutnik p : pravokutnici) { 
			System.out.println(p.getNaziv() + ": " + p.opseg() + " - " + p.getMjesto().getNaziv());
		}
		
		
		Pravokutnik[] josKrace = {kreiraj("Prvi",12,10),kreiraj("Drugi",23,11)};
		
		Pravokutnik[] najkrace = {new Pravokutnik("Treæi",12,34)};
	}
	
	static Pravokutnik kreiraj(String naziv, int duzina, int sirina) {
		Pravokutnik pravokutnik = new Pravokutnik();
		pravokutnik.setNaziv(naziv);
		pravokutnik.setDuzina(duzina);
		pravokutnik.setSirina(sirina);
		return pravokutnik;
	}

}
