package klase;

public class Main {
	
	public static void main(String[] args) {
		
		Vlasnik srdan = new Vlasnik(1,"Sr�an","Filipovi�","75919144249","0981907457","srdjanfilipovic991@gmail.com","13-10-1990","mu�ko");
		
		System.out.println("Podaci vlasnika: ");
		System.out.println(srdan.dohvatiPodatkeVlasnika()+"\n");
		
		Auto auto = new Auto(1,"Aston Martin",2020,45,"JB-007-OS",1);
		
		System.out.println("Podaci auta: ");
		System.out.println(auto.dohvatiPodatkeAuta());
	}
	


}
