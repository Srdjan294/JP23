package Klase;

public class PreopterecivanjeKonstruktora {
	
	public static void main(String[] args) {
		
		Student s1 = new Student();
		Student s2 = new Student(1,"Pero","Peri�");
		Student s3 = new Student("Ani�");
		
		System.out.println(s1.dohvatiPodatke());
		System.out.println(s2.dohvatiPodatke());
		System.out.println(s3.dohvatiPodatke());
	}

}
