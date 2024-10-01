package ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		char c1, c2;
		
		for(int i=0, t=input.length()-1; i<t; i++, t--) {
			c1 = input.charAt(i);
			c2 = input.charAt(t);
			if (c1!=c2) {
				System.exit(1);
			}
		}
		//se lo añado por los ejecicios de multiprocesos 3, que necesita salida
		System.out.println("Es un palíndromo");
		System.exit(0);
	}
}
