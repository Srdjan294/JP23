package edunova.crud;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.reflect.TypeToken;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

public class Start {

	private List<Smjer> smjerovi;
	private static final String PUTANJA_SMJEROVI = "smjerovi.json";
	
	public Start() {
		smjerovi = new ArrayList<>();
		ucitajSmjerove();
		izbornik();
	}
	
	private void ucitajSmjerove() {
		if(!new File(PUTANJA_SMJEROVI).exists()) {
			return;
		}
		
		try {
			Type listType = new TypeToken<List<Smjer>>(){}.getType();
			String json=Files.readString(Path.of(PUTANJA_SMJEROVI));
			smjerovi = new Gson().fromJson(json, listType);
		}catch(Exception e) {
			e.printStackTrace();
			// obavijestiti korisnika
		}
		
		
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
				System.out.println("Doviðenja");
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
		case 3: 
			promjeniSmjer();
			break;
		case 4:
			obrisiSmjer();
		case 5: 
			izbornik();
			break;
		}
		
	}

	private void obrisiSmjer() {
		
		smjerovi.remove(odaberiSmjer());
		spremi();
		smjerIzbornik();
		
	}
	
	private int odaberiSmjer() {
		sviSmjerovi();
		return Pomocno.ucitajCijeliBroj("Odaberite redni broj stavke", 1, smjerovi.size())-1;
		
		
	}

	private void promjeniSmjer() {
		var odabir = odaberiSmjer();
		var s = smjerovi.get(odabir);
		
		s.setSifra(Pomocno.ucitajCijeliBroj("Šifra (" + s.getSifra() + ")"));
		s.setNaziv(Pomocno.ucitajString("Naziv (" + s.getNaziv() + ")"));
		
		// ova linija i nije potrebna. Tu je da pokaže set metodu na List suèelju:
		smjerovi.set(odabir, s);
		spremi();
		smjerIzbornik();
	}

	private void dodajNoviSmjer() {
		Smjer s = new Smjer();
		s.setSifra(Pomocno.ucitajCijeliBroj("Unesi šifru smjera"));
		s.setNaziv(Pomocno.ucitajString("Unesi naziv smjera"));
		s.setGrupe(ucitajGrupe());
		smjerovi.add(s);
		spremi();
		smjerIzbornik();
	}

	private List<Grupa> ucitajGrupe() {
		List<Grupa> grupe = new ArrayList<>();
		
		if(Pomocno.ucitajCijeliBroj("1 za unos grupa")!=1) {
			return grupe;
		}
		Grupa g;
		while(true) {
			System.out.println("Unos nove grupe");
			g = new Grupa();
			g.setNaziv(Pomocno.ucitajString("Naziv grupe"));
			g.setDatumPocetka(Pomocno.ucitajDatum("Unesite datum grupe"));
			grupe.add(g);
			if(Pomocno.ucitajCijeliBroj("0 za prekid unosa")==0) {
				break;
			}
		}
		return grupe;
		
	}

	private void stavkeSmjerIzbornika() {
		System.out.println("1. Prikazi sve smjerove");
		System.out.println("2. Dodaj novi smjer");
		System.out.println("3. Promjeni postojeæi smjer");
		System.out.println("4. Obriši postojeæi smjer");
		System.out.println("5. Vraæanje na glavni izbornik");
		
	}
	
	private void sviSmjerovi() {
		System.out.println("+++++++++++++++++++++++");
		for(int i = 0; i < smjerovi.size(); i++) {
			var s = smjerovi.get(i);
			System.out.println((i+1) + ". " + s.getNaziv());
			if(s.getGrupe().isEmpty()) {
				continue;
			}
			System.out.println("\tGrupe: ");
			for(Grupa g: s.getGrupe()) {
				System.out.println("\t\t" + g.getNaziv());
			}
		}
		
		System.out.println("+++++++++++++++++++++++");
	}

	private void prikaziSmjerove() {
		sviSmjerovi();
		smjerIzbornik();
	}	

	private void stavkeIzbornika() {
		System.out.println("1. Smjerovi");
		System.out.println("2. Grupe");
		System.out.println("3. Polaznici");
		System.out.println("4. Predavaèi");
		System.out.println("5. Izlaz");
		
	}
	
	private void spremi() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//System.out.println(gson.toJson(smjerovi));
		
		try {
			FileWriter fw = new FileWriter(new File(PUTANJA_SMJEROVI));
			fw.write(gson.toJson(smjerovi));
			fw.close();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Start();
	}

}
