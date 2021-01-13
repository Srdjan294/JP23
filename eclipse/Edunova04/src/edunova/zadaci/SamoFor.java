package edunova.zadaci;

import java.util.Scanner;

public class SamoFor {

	public static void main(String[] args) {
Scanner input = new Scanner(System.in);
		
		System.out.println("Enter size of the matrix: ");
		
		int size=input.nextInt();
		
		int xz = size - 1;
		int yz = size - 1;

		int xa = 0; int ya = 0;
		
		System.out.println("Enter starting number: ");
		
		int start=input.nextInt();
		
		input.close();
		
		int num = start;

		int[][] table = new int[size][size];

		for (;;) {
			if((num-start) >= (size * size)) {
				break;
			}
			for (int i = yz; i >= ya; i--) {   //bot right --> bot left
				table[xz][i] = num++;
			}
			xz--;

			for (int i = xz; i >= xa; i--) {   //bot left --> top left
				table[i][ya] = num++;
			}
			ya++;

			for (int i = ya; i <= yz; i++) {  //top left --> top right
				table[xa][i] = num++;
			}
			xa++;

			for (int i = xa; i <= xz; i++) {  //top right --> bot right
				table[i][yz] = num++;
			}
			yz--;

		}

		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				System.out.format("%4d ",table[i][j]);
			}
			System.out.println("\n");
		}
	}
}
