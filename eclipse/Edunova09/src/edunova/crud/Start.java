package edunova.crud;

import java.util.ArrayList;
import java.util.List;

public class Start {
	
	private List<Smjer> smjerovi;
	
	public Start() {
		smjerovi = new ArrayList<>();
		izbornik();
	}
	
	private void izbornik() {
		System.out.println("********* EDUNOVA CRUD *********");
		stavkeIzbornika();
		 
		switch(Pomocno.ucitajCijeliBroj("Odaberite akciju",1,5)) {
		case 1: 
			smjerIzbornik();
			break;
			// ostale stavke izbornika
		case 5:
				System.out.println("Dovi�enja");
				break;
		}
	}

	private void smjerIzbornik() {
		System.out.println("Rad s smjerovima");
		stavkeSmjerIzbornika();
		switch(Pomocno.ucitajCijeliBroj("Odaberite akciju",1,5)) {
		case 1: 
			prikaziSmjerove();
			break;
		case 2: 
			dodajNoviSmjer();
			break;
		case 5: 
			izbornik();
			break;
		}
		
	}

	private void dodajNoviSmjer() {
		Smjer s = new Smjer();
		s.setSifra(Pomocno.ucitajCijeliBroj("Unesi �ifru smjera"));
		s.setNaziv(Pomocno.ucitajString("Unesi naziv smjera"));
		smjerovi.add(s);
		smjerIzbornik();
	}

	private void stavkeSmjerIzbornika() {
		System.out.println("1. Prikazi sve smjerove");
		System.out.println("2. Dodaj novi smjer");
		System.out.println("3. Promjeni postoje�i smjer");
		System.out.println("4. Obri�i postoje�i smjer");
		System.out.println("5. Vra�anje na glavni izbornik");
		
	}

	private void prikaziSmjerove() {
		System.out.println("+++++++++++++++++++++++");
		for(Smjer smjer : smjerovi) {
		System.out.println(smjer.getNaziv());
		}
		System.out.println("+++++++++++++++++++++++");
		smjerIzbornik();
	}	

	private void stavkeIzbornika() {
		System.out.println("1. Smjerovi");
		System.out.println("2. Grupe");
		System.out.println("3. Polaznici");
		System.out.println("4. Predava�i");
		System.out.println("5. Izlaz");
		
	}

	public static void main(String[] args) {
		new Start();
	}

}
