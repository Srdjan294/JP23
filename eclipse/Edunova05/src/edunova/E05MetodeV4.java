package edunova;

public class E05MetodeV4 {
	
	/**
	 * 4. vrsta metode
	 * ne prima parametre - u zagradama je prazno
	 * vra�a vrijednost onog tipa s kojim je definirana (int)
	 * naziv je slucajniBroj
	 * @return Slu�ajni broj izme�u 0 i 99
	 */
	public static int slucajniBroj() {
		return (int) (Math.random()*100);
	}

}
