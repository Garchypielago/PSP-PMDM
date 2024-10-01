package ejercicios;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) throws IOException {

		// Aqui pido el dato a mandar al proceso hijo
		System.out.println("Escribe un  número entero positivo:");
		Scanner sc = new Scanner(System.in);
		String respuesta = sc.nextLine();

		// Directorio del porceso que quiero llamar
		File directorio = new File(
				"E:\\Escritorio\\Git_REPOSITORIOS\\Curso02\\PSP+PMDM\\PSP\\Eclipse\\T-2\\Ej2_Multiprocesos_Hijos\\bin");
		// Tipo de proceso y archivo (depende del especificdo)
		ProcessBuilder pb = new ProcessBuilder("java", "ejercicios.Ejercicio01");
		// Agrego donde esta el programa
		pb.directory(directorio);

		Process p = pb.start();

		// Aui mandas el proceso al hijo
		respuesta = respuesta + "\n";
		OutputStream os = p.getOutputStream();
		os.write(respuesta.getBytes());
		// os.flush(); // vacía el buffer de salida
		os.close();

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