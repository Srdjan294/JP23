package auto.crud;

import java.util.Date;

public class Vlasnik {
	
	private int sifra;
	private String ime;
	private String prezime;
	private String oib;
	private String brojMobitela;
	private String email;
	private Date datumRodenja;
	private String spol;
	
	
	public String getSpol() {
		return spol;
	}
	public void setSpol(String spol) {
		this.spol = spol;
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
	public Date getDatumRodenja() {
		return datumRodenja;
	}
	public void setDatumRodenja(Date datumRodenja) {
		this.datumRodenja = datumRodenja;
	}
	public int getSifra() {
		return sifra;
	}
	public void setSifra(int sifra) {
		this.sifra = sifra;
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
	
	

}
