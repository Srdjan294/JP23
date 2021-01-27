package edunova.primjer1;

public class Polaznik extends Osoba {

	private String brojUgovora;
	private int status;
	
	public Polaznik() {
		//super();
		System.out.println("konstruktor Polaznik " + status);
	}

	
	public Polaznik(String ime, String prezime, String brojUgovora) {
//		setIme(ime);         - ovo se ne radi
//		setPrezime(prezime); - ovo se ne radi 
		super(ime, prezime);  // parametri od nadklase
		this.brojUgovora = brojUgovora;
	}


	public String getBrojUgovora() {
		return brojUgovora;
	}

	public void setBrojUgovora(String brojUgovora) {
		// kada se obraæam prvoj nadklasi koristim kljuènu rijeè super
		super.status = 1; // protected int status; iz nadklase
		this.status = 2; // private int status
		this.brojUgovora = brojUgovora;
	}
	
	
}
