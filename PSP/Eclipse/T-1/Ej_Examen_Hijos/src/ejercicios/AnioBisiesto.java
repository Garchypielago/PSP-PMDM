package ejercicios;

import java.util.Scanner;

public class AnioBisiesto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int anio = sc.nextInt();
		
		if ((anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0) {
			System.out.println("El número generado es: " + anio + " y SI es bisiesto");
			System.exit(0);
		} else {
			System.out.println("El número generado es: " + anio + " y NO es bisiesto");
			System.exit(0);
		}
		
		System.exit(-1);
	}

}
