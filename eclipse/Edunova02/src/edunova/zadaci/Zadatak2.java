package edunova.zadaci;

public class Zadatak2 {
	
	public static void main(String[] args) {
		int i=2,j=1,t;
		
		i+=j; 
		System.out.println(i);
		System.out.println(j);
		System.out.println("-------");
		
		t=j+i++; 
		System.out.println(j);
		System.out.println(i);
		System.out.println(t);
		System.out.println("-------");
		
		j+=1; 
		System.out.println(j);
		System.out.println("-------");
		
		System.out.println(i+j+t);
		// bez izvoðenja dobiti rezultat koji se provjeri izvoðenjem
	}

}


