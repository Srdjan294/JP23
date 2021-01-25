package klase;

public class Oznaka {
	
	private int sifra;
	private String naziv;
	
	//getteri i setteri
	public int getSifra() {
		return sifra;
	}
	public void setSifra(int sifra) {
		this.sifra = sifra;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	//konstruktor
	public Oznaka(int sifra, String naziv) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
	}


}
