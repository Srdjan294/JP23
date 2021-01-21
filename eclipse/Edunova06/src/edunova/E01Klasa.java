package edunova;

// Klasa je opisnik objekta

public class E01Klasa {
	
	// OOP prinicip U�ahurivanje / Encapsulation
	// klasa skriva svoja svojstva
	// svojstvo klase - varijabla na razini klase
	private int visina;

	// skriveno svojstvo klasa �ini dostupnim putem javnih get/set metoda
	
	public int getVisina() {
		return visina;
	}

	public void setVisina(int visina) {
		//this je klju�na rije� kojom se obra�amo razini klase, ne metode
		this.visina = visina;
	}
	
	

}
