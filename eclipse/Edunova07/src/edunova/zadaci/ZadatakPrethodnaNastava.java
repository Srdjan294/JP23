package edunova.zadaci;

public class ZadatakPrethodnaNastava {
	
	// Kreirajte privatnu unutarnju klasu u ovoj klasi
	// koja se zove Dokumente i ima 4 svojstva razlièitih tipova podataka
	// definirajte tri razlièita konstruktora
	// u main metodi ove klase napravite niz Dokumenata
	// u koji æete postaviti 3 instance s popunjenim vrijednostima
	// stvojstava
	
	void posao() {
		@SuppressWarnings("unused")
		int i = ucitaj("Unesi");
	}
	
	private int ucitaj(String string) {
		// TODO Auto-generated method stub
		return 0;
	}

	private class Dokument{
		
		private int id;
		private char simbol;
		private boolean stanje;
		private double podatak;
		
		
		public Dokument() {
			super();
		}


		public Dokument(int id, char simbol) {
			super();
			this.id = id;
			this.simbol = simbol;
		}


		public Dokument(int id, char simbol, boolean stanje, double podatak) {
			super();
			this.id = id;
			this.simbol = simbol;
			this.stanje = stanje;
			this.podatak = podatak;
		}
	}
	 
	 public ZadatakPrethodnaNastava() {
			
			Dokument[] doc = new Dokument[3];
			
			for(int i = 0; i < doc.length; i++) {
				doc[i] = new Dokument(i,'a');
			}
		}
		
		public static void main(String[] args) {
			
			 new ZadatakPrethodnaNastava();
		}
	

}
