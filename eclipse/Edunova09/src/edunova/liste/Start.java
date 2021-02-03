package edunova.liste;

import java.util.List;
import java.util.ArrayList;

public class Start {
	
	public Start() {
		//imam prostora za pohranu samo 2 stringa, na 3 puca
//		String[] imena = new String[2];
//		imena[0] = "Ana";
//		imena[1] = "Marin";
//		imena[2] = "Karlo";
		
		//imena.add, imena.push - ne postoje ove metode
		
		//loše
		
		ArrayList lista = new ArrayList();
		lista.add(new Osoba("Ana"));
		lista.add(new Osoba("Ana","Brekalo"));
		lista.add(new Osoba("Karlo"));
		lista.add("Pero");
		
		System.out.println(lista.get(0));
		
		System.out.println(lista.get(1));
		
		System.out.println(lista.get(0).equals(lista.get(1)));
		
		
		// BEST PRACTICE
		// korištenje generièkih klasa
		// s lijeve strane dolazi suèelje a s desne dolazi implementacija
		List<Osoba> l = new ArrayList<>();
		l.add(new Osoba("Ana"));
		l.add(new Osoba("Ana", "Brekalo"));
		
		System.out.println(l.get(0).getPrezime());
	}
	
	public static void main(String[] args) {
		new Start();
	}
	
		
}

