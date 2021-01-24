package Klase;

import java.util.ArrayList;

public class Student {
	
	private int brojIndeksa;
	private String ime;
	private String prezime;
	private ArrayList<String> prijavljeniIspiti = new ArrayList<String>();
	
	//ID prijavljenog ispita ubacuje u listu
	public void prijaviIspit(String ispit) {
		//implementacija metode - primjena poslovne logike
		prijavljeniIspiti.add(ispit);
	}
	
	public String dohvatiPodatke() {
		return "Ime: " + ime + "\n" + "Prezime: " + prezime + "\n" +
				"Broj indeksa: " + brojIndeksa + "\n" + 
				"Student je prijavio sljedeæe ispite: " + prijavljeniIspiti + "\n";
 	}

	public int getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(int brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
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

	public ArrayList<String> getPrijavljeniIspiti() {
		return prijavljeniIspiti;
	}

	public void setPrijavljeniIspiti(ArrayList<String> prijavljeniIspiti) {
		this.prijavljeniIspiti = prijavljeniIspiti;
	}

	public Student(int brojIndeksa, String ime, String prezime) {
		super();
		this.brojIndeksa = brojIndeksa;
		this.ime = ime;
		this.prezime = prezime;
	}
	
	

}
