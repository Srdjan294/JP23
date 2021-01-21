package edunova.zadaci;

public class Osoba {
	
	// OOP principom uèahurivanja opišite osobu s tri svojstva
	// sva tri su primitivnih tipova podataka
	
	// u main metodi ove iste klasa 
	// kreirajte jednu instacu Osobe i 
	// svim svojstvima dodjelite vrijednosti
	
	private int masa;
	private int visina;
	private int godina;
	
	public int getMasa() {
		return masa;
	}
	public void setMasa(int masa) {
		this.masa = masa;
	}
	public int getVisina() {
		return visina;
	}
	public void setVisina(int visina) {
		this.visina = visina;
	}
	public int getGodina() {
		return godina;
	}
	public void setGodina(int godina) {
		this.godina = godina;
	}
	
	public static void main(String[] args) {
		
		Osoba covjek = new Osoba();
		
		covjek.setGodina(30);
		covjek.setMasa(75);
		covjek.setVisina(175);
		
		System.out.println(covjek.getGodina());
	}

}
