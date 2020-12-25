package edunova;

public class E02UvjetnoGrananjeIf {
	
	public static void main(String[] args) {
		
		int i=8; // ja ne znam za ovih 7
		int j=10; //ja ne znam za ovih 10
		
		//osnovni if
		if(i==7) { // uvijek u if koristiti viti�aste zagrade
			System.out.println("To je OK");
		}
		
		if(i==7)
			System.out.println("To je isto OK");
		//kada if nema {} onda se odnosi samo na prvu sljede�u liniju
		
		if(i==7) {
			System.out.println("Pero");
		    System.out.println("Pero");
		}
			
		
		//puni if
		if(i==7) {
			System.out.println("OK");
		}else {
			System.out.println("NE");
		}
		
		//ugnje��eni if
		if(i==7) { 
			if(j==10) {
				System.out.println("1OK 1");
			}
		}
		
		//izraz iznad se ipak pi�e na ovaj na�in
		if(i==7 & j==10) {
			System.out.println("2OK 1");
		}
		
		// operator & �e provjeravati oba uvjeta
		// operater && koji ne provjerava drugi uvjet ako prvi nije zadovoljen
		
		// uobi�ajenija sintaksa
		if(i==7 && j==10) {
			System.out.println("3OK 1");
		}
		System.out.println(i + " - " + j);
		if(i>4 | j<5) {
			System.out.println("4OK 2");
		}
		
		if(i>4 || j<5) {
			System.out.println("5OK 2");
		}
		// || u slu�aju zadovoljenja 1. uvjeta drugi se ne provjerava
		
		if(i!=7 || !(i<6)) {
			System.out.println("6OK 3" );
		}
		
		
		boolean uvjet;
		uvjet=i!=7;
		
		if(uvjet) {
			// ako je uvjet true
			System.out.println("uvjet=i!=7");
		}else {
			// ako je uvjet false
			System.out.println("XXX");
		}
		
		//VE�A GRE�KA
		boolean ozenjen=true;
		
		if(ozenjen==true) {
			System.out.println("O�enjen");
		}
		
		if(ozenjen) {
			System.out.println("O�enjen");
		}
		
		
		
		if(i==7) {
			System.out.println("7");
		}else if(i==8) {
			System.out.println(8);
		}else if(i==9) {
			System.out.println(9);
		}else {
			System.out.println("Ostalo");
		}
		//bolje rje�enje je switch.
		
		i=2;
		if(i==2) {
			System.out.println("OK");
		}else {
			System.out.println("NE");
		}
		
		// inline if
		System.out.println(i==2 ? "OK" : "NE");
		
		j = i==7 ? 1 : 2;
		
		System.out.println(j);
		
	}

}
