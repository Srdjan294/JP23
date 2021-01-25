package klase;

public class Evidencija {
	
	private int sifraEvidencija;
	private int sifraAuto;
	private String datum;
	private int natocenoLitara;
	private int ukupnaCijena;
	private int pocetnoStanje;
	private int zavrsnoStanje;
	
	//getteri i setteri
	public int getSifraEvidencija() {
		return sifraEvidencija;
	}
	public void setSifraEvidencija(int sifraEvidencija) {
		this.sifraEvidencija = sifraEvidencija;
	}
	public int getSifraAuto() {
		return sifraAuto;
	}
	public void setSifraAuto(int sifraAuto) {
		this.sifraAuto = sifraAuto;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	public int getNatocenoLitara() {
		return natocenoLitara;
	}
	public void setNatocenoLitara(int natocenoLitara) {
		this.natocenoLitara = natocenoLitara;
	}
	public int getUkupnaCijena() {
		return ukupnaCijena;
	}
	public void setUkupnaCijena(int ukupnaCijena) {
		this.ukupnaCijena = ukupnaCijena;
	}
	public int getPocetnoStanje() {
		return pocetnoStanje;
	}
	public void setPocetnoStanje(int pocetnoStanje) {
		this.pocetnoStanje = pocetnoStanje;
	}
	public int getZavrsnoStanje() {
		return zavrsnoStanje;
	}
	public void setZavrsnoStanje(int zavrsnoStanje) {
		this.zavrsnoStanje = zavrsnoStanje;
	}
	
	//konstruktor
	public Evidencija(int sifraEvidencija, int sifraAuto, String datum, int natocenoLitara, int ukupnaCijena,
			int pocetnoStanje, int zavrsnoStanje) {
		super();
		this.sifraEvidencija = sifraEvidencija;
		this.sifraAuto = sifraAuto;
		this.datum = datum;
		this.natocenoLitara = natocenoLitara;
		this.ukupnaCijena = ukupnaCijena;
		this.pocetnoStanje = pocetnoStanje;
		this.zavrsnoStanje = zavrsnoStanje;
	}
	
	public String dovhvatiEvidenciju() {
		return "Sifra: " + sifraEvidencija + "\n" + 
				"Auto: " + sifraAuto + "\n" + 
				"Datum: " + datum + "\n" + 
				"Natoèeno litara: " + natocenoLitara + "\n" + 
				"Ukupna cijena: " + ukupnaCijena + "\n" + 
				"Poèetno stanje brojila: " + pocetnoStanje + "\n" + 
				"Završno stanje brojila: " + zavrsnoStanje;
	}
	
	

	
}
