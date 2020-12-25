package edunova;

public class E02ForPetlja {
	
	public static void main(String[] args)  {
		
		// koristi se kada znate od kuda, do kuda i u kojem koraku idete
		
		// for(od kuda; do kuda; korak)
		
		for(int i=0; i<10; i++) {
			System.out.println("Osijek");
		}
		
		for(int i=0; i<10; i++) {
			System.out.println(i);
		}
		
		
		// zbroj prvih 100 brojeva
		int zbroj=0;
		for(int i=1;i<=100;i++) {
			zbroj+=i;
		}
		System.out.println(zbroj);
		
		
		
		
		// moguænost preskakanja koraka/ nastavljanje izvoðenja
		
		for(int i=0;i<10;i++) {
			if(i==3) {
				continue;
			}
			
			System.out.println("broj je: " + i);
		}
		
		//moguænost nasilnog prekida petlje
		
		for(int i=0;i<10;i++) {
			if(i==6) {
				break;
			}
			
			System.out.println(i);
		}
		
		// ugnježðivanje petlji
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				System.out.print((i+1)*(j+1) + " ");
			}
			System.out.println();
		}
		
		
		
		// beskonaèna petlja
		//for(int i=0; i>0;i++) { // ovo nije beskonaèna petlja
			
		//}
		
		for(;;) {
			System.out.println(Math.random());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
	}

}