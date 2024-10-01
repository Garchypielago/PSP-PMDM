package ejercicios;

import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		double num;
		
		try {
			num = Double.parseDouble(sc.nextLine());
			if (num != (int)num) {
				System.exit(-2);
			} else if (num>=0) {
				System.exit(-3);
			} else {
				System.exit(0);
			}
		} catch (NumberFormatException e) {
			System.exit(-1);
		}

	}

}