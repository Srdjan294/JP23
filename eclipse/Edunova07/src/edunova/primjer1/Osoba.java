package edunova.primjer1;

// apstraktna klasa je ona klasa koja se ne mo�e instancirati
public abstract class Osoba extends Object {

	private String ime;
	private String prezime;
	protected int status;
	
	public Osoba() {
		//super(); - ako se naslje�uje Object i nemora se zvati konstruktor nadklase
		System.out.println("konstruktor osoba");
	}
	
	
	public Osoba(String ime, String prezime) {
		super();
		this.ime = ime;
		this.prezime = prezime;
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
