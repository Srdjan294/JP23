package edunova;

/**
 * 
 * @author Filipoviæ Srðan
 *
 */

public class E02MetodaV1 {
	
	
	/**
	 * 1. vrsta metode
	 * ne prima parametar  () nakon naziva su prazne
	 * ne vraæa vrijednost (void)
	 */
	public static void odradiPosao() {
		System.out.println("E02MetodaV1.odradiPosao()");
		for(int i = 0; i < 10; i++) {
			System.out.println("Osijek");
		}
	}
	
	/**
	 * Kada nije definiran naèin pristupa tada se misli na package
	 */
	static void packageScope() {
		
	}
	
	void nijeStatic() {
		
	}

}
