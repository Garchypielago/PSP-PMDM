package ejercicios;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) throws IOException {

		File directorio = new File("E:\\Escritorio\\Git_REPOSITORIOS\\Curso02\\PSP+PMDM\\PSP\\Eclipse\\T-2\\Ej2_Multiprocesos_Hijos\\bin");
		
		ProcessBuilder pb = new ProcessBuilder("java", "ejercicios.Ejercicio01");
		pb.directory(directorio);

		File fBat = new File("E:\\Escritorio\\Git_REPOSITORIOS\\Curso02\\PSP+PMDM\\PSP\\Eclipse\\T-2\\Ej3_Multiprocesos_Padres\\TXT\\entrada_ej01.txt");
		
		pb.redirectInput(fBat);

		Process p = pb.start();

		// COMPROBACION DE ERROR - 0 bien - 1 mal
		try {
			int exitVal = p.waitFor();
		
			switch (exitVal) {
			case -3:
				System.out.println("Has escrito un entero positivo.");
				break;
			case -2:
				System.out.println("Debe ser un entero.");
				break;
			case -1:
				System.out.println("Debe ser un numero.");
				break;
			case 0:
				System.out.println("Debe ser positivo.");
				break;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}