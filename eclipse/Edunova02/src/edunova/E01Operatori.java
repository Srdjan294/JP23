package edunova;

public class E01Operatori {
	
	public static void main(String[] args) {
		//https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html
		
		int i=2, j=4; //zamislimo da je pomo�u JOptionPane korisnik svaki puta unio ove vrijednosti
		int rezultat=i+j;
		System.out.println(rezultat);
		
		// - * /
		
		// modulo % ostatak nakon cjelobrojnog djeljenja
		
		i=9%2;
		System.out.println(i);
		
		rezultat=rezultat+1;
		rezultat+=1; //isti u�inak kao linija iznad
		
		rezultat=rezultat+i;
		rezultat+=i;//isti u�inak kao linija iznad
		System.out.println("--------------");
		// ista pravila vrijede i za ostale operatore u kombinaciji s =
		
		// ++ --
		
		// uve�anje za 1
		i=i+1; // 1. na�in
		i+=1; // drugi na�in
		System.out.println(i);
		i++; //tre�i na�in - prvo se koristi vrijednost pa se uve�a
		System.out.println(i);
		++i; //prvo uve�a pa se koristi vrijednost
		System.out.println(i);
		
		i=1;
		System.out.println(i++); //2
		System.out.println(++i); //3
		System.out.println(i); //3
		
		
		i=i-1;
		i-=1;
		i--;
		
		i=1;
		System.out.println(i--); //0
		System.out.println(--i); //-1
		System.out.println(i); //-1
	}

}

