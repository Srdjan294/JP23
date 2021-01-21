package edunova;

// Klasa je opisnik objekta

public class E01Klasa {
	
	// OOP prinicip Uèahurivanje / Encapsulation
	// klasa skriva svoja svojstva
	// svojstvo klase - varijabla na razini klase
	private int visina;

	// skriveno svojstvo klasa èini dostupnim putem javnih get/set metoda
	
	public int getVisina() {
		return visina;
	}

	public void setVisina(int visina) {
		//this je kljuèna rijeè kojom se obraæamo razini klase, ne metode
		this.visina = visina;
	}
	
	

}
