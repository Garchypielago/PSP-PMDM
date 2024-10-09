package ejercicio01;

import java.util.ArrayList;

public class Impares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> repetidos = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) {
			int num = (int) (Math.random() * 99);
			if (num % 2 == 0) {
				num++;
			}
			if (repetidos.contains(num)) {
				i--;
			} else {
				System.out.println(num);
				repetidos.add(num);
			}
		}
		System.exit(0);

	}

}
