package Klase;

public class StatickiClanPrimjer {
	
	public static void main(String[] args) {
		
		Student s1 = new Student(2310,"Pero","Peri�");
		Student s2 = new Student(2311,"Ana","Ani�");
		Student s3 = new Student(2312,"Maja","Maji�");
		System.out.println("Kreirane su " + Student.getBrojInstanci() + " instance");
		
	}

}
