package edunova;

import java.util.Arrays;

public class E01Nizovi {

	public static void main(String[] args) {
		// potreba za pohranom vi�e vrijednosti istog tipa
		// �elim pohraniti temperature u zadnjih 12 mjeseci
		
		//deklaracija
		int[] niz; //osobna preferenca predava�a
		
		
		// inicijalizacija
		niz = new int[12]; // alocirali 12 elemenata niza s zadanim vrijednostima tipa podatka (0)
		int polje[]= {1,2,3,4}; //alocirali 4 elementa niza s vrijednostima 1-4
		
		
		// kori�tenje
		// elementima niza se pristupa putem indexa. Index kre�e od broja 0
		//na prvi element niza niz postavimo vrijednost -6
		niz[0]=-6;
		polje[polje.length-1]=1; //postaviti na zadnji element
		
		System.out.println(niz[0]);
		System.out.println(polje[polje.length-1]);
		
		
		//uobi�ajena sintaksa
		int[] mjeseci = new int[12];
		
		
		char[] konstante = {'A','K','R'};
		
		//ispi�ite K
		
		//svi nizovi iznad su bili jednodimenzionalni nizovi
		
		
		// vi�edimenzionalni nizovi
		
		//2d
		int[][] tablica = new int[5][5];
		
		tablica[0][0]=2;
		tablica[1][1]=2;
		tablica[2][2]=2;
		tablica[3][3]=2;
		tablica[4][4]=2;
		
		System.out.println(Arrays.toString(tablica[0]));
		System.out.println(Arrays.toString(tablica[1]));
		System.out.println(Arrays.toString(tablica[2]));
		System.out.println(Arrays.toString(tablica[3]));
		System.out.println(Arrays.toString(tablica[4]));
		
		// postoje i vi�edimenzionalni nizovi
		int[][][] kocka= new int[10][10][10];
		
	}

}