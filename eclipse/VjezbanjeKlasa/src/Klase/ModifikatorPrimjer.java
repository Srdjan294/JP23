package Klase;

public class ModifikatorPrimjer {
	
	public static void main(String[] args) {
//		Student s = new Student();
//		s.setIme("Pero");
//		s.setPrezime("Peri�");
//		s.setBrojIndeksa(2310);
		Student s = new Student(2310,"Pero","Peri�");
		s.prijaviIspit("Java");
		s.prijaviIspit("OOP");
		System.out.println(s.dohvatiPodatke());
	}

}
