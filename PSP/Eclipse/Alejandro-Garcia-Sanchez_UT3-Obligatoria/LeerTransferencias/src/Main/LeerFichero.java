package Main;

import java.io.*;
import java.util.*;
import hilos.*;

public class LeerFichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc_generar = new Scanner(System.in);

		System.out.println("Escribe el nombre del nombre del archivo:");
		String nombre = sc_generar.nextLine();

		/*
		 transacciones.txt
E:\Escritorio\Git_REPOSITORIOS\Curso02\PSP-PMDM\PSP\Eclipse\Alejandro-Garcia-Sanchez_UT3-Obligatoria\TXT\
200
		 
		 */
		
		System.out.println("Escribe la ruta del fichero (acabalo en barra):");
		String path = sc_generar.nextLine();

		System.out.println("Escribe el número de transferencias a generar:");
		int numero = Integer.parseInt(sc_generar.nextLine());

		String inputs = nombre + "\n" + path + "\n" + String.valueOf(numero) + "\n";

		Double saldo = ((double) (new Random().nextInt(200000, 300001)) / 100) * numero;
		
		sc_generar.close();

		// aqui llamo al proceso01
		int exitVal = generacionFichero(inputs);

		switch (exitVal) {
		case -2:
			System.out.println("No ha llegado el archivo de transferencias.");
			break;
		case -1:
			System.out.println("Error al generar el archivo.");
			break;
		case 0:
			File fichero = new File(path + nombre);
			hilos(fichero, saldo, path);

			break;
		}

	}

	public static int generacionFichero(String input) {
		try {
			File directorio = new File("..\\GenereacionTransferencias\\bin");
			ProcessBuilder generar = new ProcessBuilder("java", "generacion.Generacion");
			// Agrego donde esta el programa
			generar.directory(directorio);
			Process p_generar = generar.start();

			// Aui mandas el proceso al hijo
			OutputStream os = p_generar.getOutputStream();
			os.write(input.getBytes());
			os.flush(); // vacía el buffer de salida
			os.close();

			int exitVal = -1;
			exitVal = p_generar.waitFor();
			System.out.println("Valor de salida: " + exitVal);

			if (exitVal==0) {
				Scanner sc = new Scanner(p_generar.getInputStream());
				System.out.println(sc.nextLine());
			}

			return exitVal;

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public static void hilos(File fichero, Double saldo, String path) {
		Controlador syn = new Controlador(fichero, saldo, path);
		System.out.println("El saldo de la cuenta es: " + syn.getSaldo());
		for (int i = 1; i <= 3; i++)
			new Hilo("Hilo" + i, syn).start();
	}

}