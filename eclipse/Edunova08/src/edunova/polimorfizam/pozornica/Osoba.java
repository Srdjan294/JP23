package edunova.polimorfizam.pozornica;

import java.math.BigDecimal;

public abstract class Osoba {

	
	private String ime;
	public abstract String getPozdrav();
	protected abstract BigDecimal getIznos();
	
	public void prezentirajMe() {
		System.out.println("Prezentiram: ");
		System.out.println(getPozdrav());
		System.out.println("Ja zaraðujem " + getIznos());
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}
}
