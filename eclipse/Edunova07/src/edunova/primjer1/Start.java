package edunova.primjer1;

public class Start {
	
	//konstruktor
	public Start() {
		Polaznik polaznik = new Polaznik(); //tu se poziva konstruktor iz Objecta
		polaznik.setIme("Ivan");
		polaznik.setPrezime("Mak");
		polaznik.setBrojUgovora("1/2021");
		
		//Ravnatelj ravnatelj = new Ravnatelj();
		
		//Predavac predavac = new Predavac();
		
		//Osoba osoba = new Osoba(); - ne mogu jer je apstraktna
		//osoba.setIme("Pero");

	}
	
	public static void main(String[] args) {
		/*Start s = nije potrebno*/ new Start();
	}

}
