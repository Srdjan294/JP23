package edunova.polimorfizam.pozornica;

import java.math.BigDecimal;

public class Predavac extends Osoba {

	private String ziroRacun;
	
	@Override
	public String getPozdrav() {
		StringBuilder sb = new StringBuilder();
		sb.append("Ja sam ");
		sb.append(getIme());
		sb.append(", moj žiro raèun je ");
		sb.append(getZiroRacun());
		return sb.toString();
	}

	public String getZiroRacun() {
		return ziroRacun;
	}

	public void setZiroRacun(String ziroRacun) {
		this.ziroRacun = ziroRacun;
	}

	@Override
	protected BigDecimal getIznos() {
		BigDecimal broj = new BigDecimal(0);
		broj = broj.add(BigDecimal.ONE);
		return broj;
	}

}
