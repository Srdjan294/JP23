package auto.crud;

import java.util.ArrayList;
import java.util.List;

public class Start {
	
	private List<Vlasnik> vlasnici;
	
	public Start() {
		vlasnici = new ArrayList<>();
		izbornik();
	}
	
	private void izbornik() {
		System.out.println("********* AUTO CRUD **********");
		stavkeIzbornika();
		
		switch(Pomocno.ucitajCijeliBroj("Odaberite akciju",1,5)) {
		case 1: 
			vlasnikIzbornik();
			break;
		case 5: 
			System.out.println("Doviðenja");
			break;
		}
		
	}

	private void vlasnikIzbornik() {
		System.out.println("Rad s vlasnicima");
		stavkeVlasnikIzbornika();
		switch(Pomocno.ucitajCijeliBroj("Odaberite akciju",1,5)) {
		case 1:
			prikaziVlasnike();
			break;
		case 2: 
			dodajNovogVlasnika();
			break;
		case 5: 
			izbornik();
			break;
		}
		
	}

	private void dodajNovogVlasnika() {
		Vlasnik v = new Vlasnik();
		v.setSifra(Pomocno.ucitajCijeliBroj("Unesi šifru vlasnika"));
		v.setIme(Pomocno.ucitajString("Unesi ime vlasnika"));
		v.setPrezime(Pomocno.ucitajString("Unesi prezime vlasnika"));
		vlasnici.add(v);
		vlasnikIzbornik();
		
	}

	private void prikaziVlasnike() {
		System.out.println("++++++++++++++++++++++++++++++");
		for(Vlasnik vlasnik: vlasnici) {
			System.out.println(vlasnik.getIme() + " " + vlasnik.getPrezime());
		}
		System.out.println("++++++++++++++++++++++++++++++");
		vlasnikIzbornik();
		
	}

	private void stavkeVlasnikIzbornika() {
		System.out.println("1. Prikazi sve vlasnike");
		System.out.println("2. Dodaj novog vlasnika");
		System.out.println("3. Promjeni postojeæeg vlasnika");
		System.out.println("4. Obriši postojeæeg vlasnika");
		System.out.println("5. Vraæanje na glavni izbornik");
		
	}

	private void stavkeIzbornika() {
		System.out.println("1. Vlasnici");
		System.out.println("2. Auti");
		System.out.println("3. Evidencije");
		System.out.println("4. Oznake");
		System.out.println("5. Izlaz");
		
	}

	public static void main(String[] args) {
		new Start();
	}

}
