package generacion;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Generacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (random() < 30) {
//			System.out.println("no");
			System.exit(-2);
		}

        try {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner("prueba_cuentas.txt\n" + "../TXT/\n" + "100\n");
		String nombre = sc.nextLine(), path = sc.nextLine();
		int numero = Integer.parseInt(sc.nextLine());

		List<String> lineas = new ArrayList<>();
        for (int i = 0; i < numero; i++) {
            lineas.add(generarCuenta() + ";" + generarSueldo());
        }

            Files.write(Paths.get(path + nombre), lineas);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        
        System.exit(0);
    }

    public static String generarCuenta() {
        int primerDigito = (new Random().nextInt(2) + 1) * 100000000;
        int restoDigitos = new Random().nextInt(99999999);
        return String.valueOf(primerDigito + restoDigitos);
    }
    
    public static String generarSueldo() {
        double sueldo = (double)(new Random().nextInt(150000,300000)) /100 ;
        return String.valueOf(sueldo);
    }

	public static int random() {
		return new Random().nextInt(101);
	}

}
