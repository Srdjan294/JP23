package Klase;

public class PreopterecivanjeKonstruktora {
	
	public static void main(String[] args) {
		
		Student s1 = new Student();
		Student s2 = new Student(1,"Pero","Periæ");
		Student s3 = new Student("Aniæ");
		
		System.out.println(s1.dohvatiPodatke());
		System.out.println(s2.dohvatiPodatke());
		System.out.println(s3.dohvatiPodatke());
	}

}
