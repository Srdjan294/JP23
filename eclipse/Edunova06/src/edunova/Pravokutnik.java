package edunova;

public class Pravokutnik {
	
	private String naziv;
	private int duzina;
	private int sirina;
	private Mjesto mjesto;
	
	
	// puni konstruktor
	public Pravokutnik(String naziv, int duzina, int sirina) {
		super();
		this.naziv = naziv;
		this.duzina = duzina;
		this.sirina = sirina;
	}
	
	
	// prazni konstruktor
	public Pravokutnik() {
		super();
	}



	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getDuzina() {
		return duzina;
	}
	public void setDuzina(int duzina) {
		this.duzina = duzina;
	}
	public int getSirina() {
		return sirina;
	}
	public void setSirina(int sirina) {
		this.sirina = sirina;
	}
	
	public int opseg() {
		return (this.duzina*2) + (sirina*2);
	}


	public Mjesto getMjesto() {
		return mjesto;
	}


	public void setMjesto(Mjesto mjesto) {
		this.mjesto = mjesto;
	}
	
	

}
