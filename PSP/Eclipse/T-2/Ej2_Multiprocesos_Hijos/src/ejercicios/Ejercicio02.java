package ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double num, suma = 0;

		try {
			while (sc.hasNext() == true) {
				num = sc.nextDouble();
				suma += num;
				System.out.println("Escrito " + num);
			}
		} catch (InputMismatchException e) {
			if (sc.next().equals("*")) {
				System.out.println("Escrito *" + "\nSuma: " + suma);
				System.exit(0);
			}

			System.exit(-1);
		}

	}

}
