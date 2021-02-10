package auto.crud;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vlasnik {
	
	private int sifra;
	private String ime;
	private String prezime;
	private String oib;
	private String brojMobitela;
	private String email;
	private Date datumRodenja;
	private String spol;
	private List<Auto> auti = new ArrayList<>();
	
	
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
	public Date getDatumRodenja() {
		return datumRodenja;
	}
	public void setDatumRodenja(Date datumRodenja) {
		this.datumRodenja = datumRodenja;
	}
	public List<Auto> getAuti() {
		return auti;
	}
	public void setAuti(List<Auto> auti) {
		this.auti = auti;
	}
	
	

}
