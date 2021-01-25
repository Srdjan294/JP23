package klase;

public class Vlasnik {
	
	private int sifraVlasnik;
	private String ime;
	private String prezime;
	private String oib;
	private String brojMobitela;
	private String email;
	private String datumRodenja;
	private String spol;
	
	//getteri i setteri
	public int getSifraVlasnik() {
		return sifraVlasnik;
	}
	public void setSifraVlasnik(int sifraVlasnik) {
		this.sifraVlasnik = sifraVlasnik;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getOib() {
		return oib;
	}
	public void setOib(String oib) {
		this.oib = oib;
	}
	public String getBrojMobitela() {
		return brojMobitela;
	}
	public void setBrojMobitela(String brojMobitela) {
		this.brojMobitela = brojMobitela;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDatumRodenja() {
		return datumRodenja;
	}
	public void setDatumRodenja(String datumRodenja) {
		this.datumRodenja = datumRodenja;
	}
	public String getSpol() {
		return spol;
	}
	public void setSpol(String spol) {
		this.spol = spol;
	}
	
	//konstruktor
	public Vlasnik(int sifraVlasnik, String ime, String prezime, String oib, String brojMobitela, String email, String datumRodenja,
			String spol) {
		super();
		this.sifraVlasnik = sifraVlasnik;
		this.ime = ime;
		this.prezime = prezime;
		this.oib = oib;
		this.brojMobitela = brojMobitela;
		this.email = email;
		this.datumRodenja = datumRodenja;
		this.spol = spol;
	}
	
	public String dohvatiPodatkeVlasnika() {
		return "Sifra: " + sifraVlasnik + "\n" + 
				"Ime: " + ime + "\n" + 
				"Prezime: " + prezime + "\n" + 
				"Oib: " + oib + "\n" + 
				"Broj mobitela: " + brojMobitela + "\n" + 
				"Email: " + email + "\n" + 
				"Datum rodenja: " + datumRodenja + "\n" + 
				"Spol: " + spol;
	}

	
	
	
	

}
