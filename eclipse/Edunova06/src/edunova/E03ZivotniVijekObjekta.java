package edunova;

public class E03ZivotniVijekObjekta {
	
	
	// 1. faza deklarirali, vrijednost je null
	private Osoba osoba;
	
	public E03ZivotniVijekObjekta() {
		System.out.println(osoba);
		
		//NullPointerException
		//System.out.println(osoba.getIme());
		// 2. faza konstruiranje
		// poziv konstruktora
		osoba = new Osoba(); // new je poziv konstruktora
		
		// 3. faza kori�tenje
		osoba.setIme("Pero");
		System.out.println(osoba.getIme());
		
		// 4. faza uni�tenje
		// mi ju ne radimo, radi je GC Garbage Collector
	}
	
	
	public static void main(String[] args) {
		new E03ZivotniVijekObjekta();
		
	}
	
	
	private class Osoba{
		
		private String ime;
		
		// 2. faza konstruktor - specifi�na metoda
		public Osoba() {
			// slu�i tome da prilikom kreiranja nove instance
			// programer ima priliku ne�to odraditi
			System.out.println("Konstruktor osobe");
		}
		
		

		public Osoba(String ime) {
			super();
			this.ime = ime;
		}



		public String getIme() {
			return ime;
		}

		public void setIme(String ime) {
			this.ime = ime;
		}
		
		
	}

}
