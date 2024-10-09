package ejercicio01;

import java.io.*;
import java.util.Scanner;

public class PadreSyso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Creacion de proceso y direccion del archivo a ejecutar
		File dir_impares = new File(
				"E:\\Escritorio\\Git_REPOSITORIOS\\Curso02\\PSP-PMDM\\PSP\\Eclipse\\Alejandro-Garcia-Sanchez_UT2-Obligatoria\\Impares\\bin");
		ProcessBuilder pb_impares = new ProcessBuilder("java", "ejercicio01.Impares");
		pb_impares.directory(dir_impares);

		//Creacion de proceso y direccion del archivo a ejecutar
		File dir_ordenar = new File(
				"E:\\Escritorio\\Git_REPOSITORIOS\\Curso02\\PSP-PMDM\\PSP\\Eclipse\\Alejandro-Garcia-Sanchez_UT2-Obligatoria\\Ordenar\\bin");
		ProcessBuilder pb_ordenar = new ProcessBuilder("java", "ejercicio01.Ordenar");
		pb_ordenar.directory(dir_ordenar);

		//variables que nos sirven para la entrada de datos y su recepcion, y para imprimir
		String numeros = "";
		int numero;

		try {
			//inicio del programa impares
			Process p_impares = pb_impares.start();

			//esperamos valor de respuesta
			int exit_impares = p_impares.waitFor();

			switch (exit_impares) {
			case -1:
				System.out.println("Error de ejecuccion de programa impares");
				break;
			case 0:
				System.out.println("Valor de salida del programa impares: "+exit_impares
									+ "\n - - - - - -");
				
				//recepcion de datos del programa impares
				InputStream is_impares = p_impares.getInputStream();
				Scanner sc_impares = new Scanner(is_impares);

				//guardado en variable todos los datos
				System.out.println("Pintando salida del programa impares:");
				while (sc_impares.hasNext()) {
					numero = Integer.parseInt(sc_impares.nextLine());
					numeros += numero + "\n";
					System.out.println("\t"+ numero);
				}
				System.out.println("Fin de salida del programa impares."
						+ "\n - - - - - -");

				is_impares.close();
				sc_impares.close();
				break;
			default:
				System.out.println("Case value no contemplado en impares");
			}

			//inicio del programa ordenar
			Process p_ordenar = pb_ordenar.start();

			//introduccion de los datos en el programa
			OutputStream os_ordenar = p_ordenar.getOutputStream();
			os_ordenar.write(numeros.getBytes());
			os_ordenar.flush();
			os_ordenar.close();

			//esperamos valor respuesta
			int exit_ordenar = p_ordenar.waitFor();

			switch (exit_ordenar) {
			case -1:
				System.out.println("Error de ejecuccion de programa ordenar");
				break;
			case 0:
				System.out.println("Valor de salida del programa ordenar: "+exit_ordenar
						+ "\n - - - - - -");
				
				//recibimos datos ordenados
				InputStream is_ordenar = p_ordenar.getInputStream();
				Scanner sc_ordenar = new Scanner(is_ordenar);

				//impresion de los datos
				System.out.println("Pintando salida del programa ordenar:");
				while (sc_ordenar.hasNext())
					System.out.println("\t"+ sc_ordenar.nextLine());
				
				System.out.println("Fin de salida del programa ordenar.");

				is_ordenar.close();
				sc_ordenar.close();
				break;
			default:
				System.out.println("Case value no contemplado en ordenar");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
