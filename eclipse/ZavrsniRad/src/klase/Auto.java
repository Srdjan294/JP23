package klase;

public class Auto {
	
	private int sifraAuto;
	private String model;
	private int godiste;
	private int volumenRezervoara;
	private String registracija;
	private int sifraVlasnik;
	
	//getteri i setteri
	public int getSifraAuto() {
		return sifraAuto;
	}
	public void setId(int sifraAuto) {
		this.sifraAuto = sifraAuto;
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
	public int getSifraVlasnik() {
		return sifraVlasnik;
	}
	public void setVlasnikId(int sifraVlasnik) {
		this.sifraVlasnik = sifraVlasnik;
	}
	
	//konstruktor
	public Auto(int sifraAuto, String model, int godiste, int volumenRezervoara, String registracija, int sifraVlasnik) {
		super();
		this.sifraAuto = sifraAuto;
		this.model = model;
		this.godiste = godiste;
		this.volumenRezervoara = volumenRezervoara;
		this.registracija = registracija;
		this.sifraVlasnik = sifraVlasnik;
	}
	
	
	
	public String dohvatiPodatkeAuta(){
		return "Sifra: " + sifraAuto + "\n" + 
				"Model: " + model + "\n" + 
				"Godište: " + godiste + "\n" + 
				"Volumen Rezervoara: " + volumenRezervoara +  "\n" +
				"Registracija: " + registracija + "\n" + 
				"Vlasnik: " + sifraVlasnik;
	}
	
	
	

}
