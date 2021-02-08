package auto.crud;

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
import com.google.gson.JsonIOException;

public class Start {
	
	private List<Vlasnik> vlasnici;
	private static final String PUTANJA_VLASNICI = "vlasnici.json";
	
	public Start() {
		vlasnici = new ArrayList<>();
		ucitajVlasnike();
		izbornik();
	}
	
	private void ucitajVlasnike() {
		if(!new File(PUTANJA_VLASNICI).exists()) {
			return;
		}
		try {
			Type listType = new TypeToken<List<Vlasnik>>(){}.getType();
			String json = Files.readString(Path.of(PUTANJA_VLASNICI));
			vlasnici = new Gson().fromJson(json, listType);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
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
		case 3: 
			promjeniVlasnika();
			break;
		case 4: 
			obrisiVlasnika();
			break;
		case 5: 
			izbornik();
			break;
		}
		
	}

	private void obrisiVlasnika() {
		sviVlasnici();
		int odabir = Pomocno.ucitajCijeliBroj("Odaberite redni broj vlasnika",1,vlasnici.size())-1;
		
		vlasnici.remove(odabir);
		vlasnikIzbornik();
	}

	private void promjeniVlasnika() {
		sviVlasnici();
		int odabir = Pomocno.ucitajCijeliBroj("Odaberite redni broj vlasnika",1,vlasnici.size())-1;
		
		var v = vlasnici.get(odabir);
		
		v.setSifra(Pomocno.ucitajCijeliBroj("Šifra (" + v.getSifra() + ")"));
		v.setIme(Pomocno.ucitajString("Ime (" + v.getIme() + ")"));
		v.setPrezime(Pomocno.ucitajString("Prezime (" + v.getPrezime() + ")"));
		v.setOib(Pomocno.ucitajString("OIB (" + v.getOib() + ")"));
		v.setBrojMobitela(Pomocno.ucitajString("Broj mobitela (" + v.getBrojMobitela() + ")"));
		v.setEmail(Pomocno.ucitajString("Email (" + v.getEmail() + ")"));
		v.setSpol(Pomocno.ucitajString("Spol (" + v.getSpol() + ")"));
		
		vlasnici.set(odabir, v);
		spremi();
		vlasnikIzbornik();
	}

	private void dodajNovogVlasnika() {
		Vlasnik v = new Vlasnik();
		v.setSifra(Pomocno.ucitajCijeliBroj("Unesi šifru vlasnika"));
		v.setIme(Pomocno.ucitajString("Unesi ime vlasnika"));
		v.setPrezime(Pomocno.ucitajString("Unesi prezime vlasnika"));
		v.setOib(Pomocno.ucitajString("Unesi oib vlasnika"));
		v.setBrojMobitela(Pomocno.ucitajString("Unesi broj mobitela vlasnika"));
		v.setEmail(Pomocno.ucitajString("Unesi email vlasnika"));
		v.setSpol(Pomocno.ucitajString("Unesi spol vlasnika"));
		v.setDatumRodenja(Pomocno.ucitajDatum("Unesi datum roðenja vlasnika"));
		vlasnici.add(v);
		spremi();
		vlasnikIzbornik();
	}

	private void spremi() {
		Gson gson = new Gson();
		
		try {
			FileWriter fw = new FileWriter(new File(PUTANJA_VLASNICI));
			fw.write(gson.toJson(vlasnici));
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void sviVlasnici() {
		System.out.println("++++++++++++++++++++++++++++++");
		for(int i = 0; i < vlasnici.size(); i++) {
			var v = vlasnici.get(i);
			System.out.printf((i+1) + ". %s, %s, %s, %s, %s, %s, %s \n",
								v.getIme(),
								v.getPrezime(),
								v.getOib(),
								v.getBrojMobitela(),
								v.getEmail(),
								v.getSpol(),
								v.getDatumRodenja());
		}
		System.out.println("++++++++++++++++++++++++++++++");
	}

	private void prikaziVlasnike() {
		sviVlasnici();
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
