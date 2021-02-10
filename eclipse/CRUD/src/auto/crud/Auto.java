package auto.crud;

public class Auto {
	
	private int sifra;
	private String model;
	private int godiste;
	private int volumenRezervoara;
	private String registracija;
	private Vlasnik vlasnik;
	
	public int getSifra() {
		return sifra;
	}
	public void setSifra(int sifra) {
		this.sifra = sifra;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getGodiste() {
		return godiste;
	}
	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}
	public int getVolumenRezervoara() {
		return volumenRezervoara;
	}
	public void setVolumenRezervoara(int volumenRezervoara) {
		this.volumenRezervoara = volumenRezervoara;
	}
	public String getRegistracija() {
		return registracija;
	}
	public void setRegistracija(String registracija) {
		this.registracija = registracija;
	}
	public Vlasnik getVlasnik() {
		return vlasnik;
	}
	public void setVlasnik(Vlasnik vlasnik) {
		this.vlasnik = vlasnik;
	}

}
