package edunova;

public class E04MetodeV3 {
	
	/**
	 * 3. vrsta metoda
	 * prima parametre - u zagradama odvojene zarezom prvo tip podatka pa naziv
	 * vra�a vrijednost onog tipa s kojim je definirana (int)
	 * naziv je zbroji
	 * @param a prvi broj
	 * @param b drugi broj
	 * @return Zbroj dva broja
	 */
	public static int zbroji(int a, int b) {
		System.out.println("E04MetodeV3.zbroji(int a, int b");
		int rez = a+b;
		return rez;
	}
	 
	//ovo je �e��i slu�aj
	public static long zbroji(long a, long b) {
		return a+b;
	}
	
	//ne mo�e
//	public static int zbroji(int a, int b) {
//		return 0;
//	}
	
	public static char zbroji(int b) {
		return 'x';
	}

}
