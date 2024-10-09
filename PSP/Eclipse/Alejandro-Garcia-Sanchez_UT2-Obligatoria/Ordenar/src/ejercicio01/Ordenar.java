package ejercicio01;

import java.util.*;

public class Ordenar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner("15\r\n"
//				+ "21\r\n"
//				+ "55\r\n"
//				+ "5\r\n"
//				+ "23\r\n"
//				+ "87\r\n"
//				+ "3\r\n"
//				+ "61\r\n"
//				+ "51\r\n"
//				+ "67\r\n"
//				+ "");

		Scanner sc = new Scanner(System.in);
		TreeSet<Integer> Tree = new TreeSet<Integer>();
		int num;

		try {
			while (sc.hasNext()) {
				num = Integer.parseInt(sc.nextLine());
				Tree.add(num);
			}
			for (int n : Tree) {
				System.out.println(n);
			}
			sc.close();
			System.exit(0);
		} catch (Exception e) {
			System.exit(-1);
		}

	}

}
