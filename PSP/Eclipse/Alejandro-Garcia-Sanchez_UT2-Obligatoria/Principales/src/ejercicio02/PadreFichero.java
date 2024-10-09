package ejercicio02;

import java.io.*;

public class PadreFichero {

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
		
		
		//creacion del ficheros donde impares guarda los datos y del cual ordenar recoge los datos a tratar
		File f_impares = new File(
				"E:\\Escritorio\\Git_REPOSITORIOS\\Curso02\\PSP-PMDM\\PSP\\Eclipse\\Alejandro-Garcia-Sanchez_UT2-Obligatoria\\Principales\\TXT\\impares.txt");
		pb_impares.redirectOutput(f_impares);

		pb_ordenar.redirectInput(f_impares);

		//fichero donde ordenar guardara los datos
		File f_ordenar = new File(
				"E:\\Escritorio\\Git_REPOSITORIOS\\Curso02\\PSP-PMDM\\PSP\\Eclipse\\Alejandro-Garcia-Sanchez_UT2-Obligatoria\\Principales\\TXT\\orden.txt");
		pb_ordenar.redirectOutput(f_ordenar);

		try {
			//inicio de progrmama impares
			Process p_impares = pb_impares.start();

			//espero respuesta
			int exit_impares = p_impares.waitFor();

			switch (exit_impares) {
			case -1:
				System.out.println("Error de ejecuccion de programa impares");
				break;
			case 0:
				System.out.println("Valor de salida del programa impares: " + exit_impares + "\n - - - - - -");
				System.out.println("Escribiendo en impares.txt" + "\n - - - - - -");

				System.out.println("Fin de escritura en impares.txt" + "\n - - - - - -");
				break;
			default:
				System.out.println("Case value no contemplado en impares");
			}

			//inicio de progrmama impares
			Process p_ordenar = pb_ordenar.start();

			//espero respuesta
			int exit_ordenar = p_ordenar.waitFor();

			switch (exit_ordenar) {
			case -1:
				System.out.println("Error de ejecuccion de programa ordenar");
				break;
			case 0:
				System.out.println("Valor de salida del programa ordenar: " + exit_ordenar + "\n - - - - - -");
				System.out.println("Escribiendo en orden.txt" + "\n - - - - - -");

				System.out.println("Fin de escritura en orden.txt" + "\n - - - - - -");
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
