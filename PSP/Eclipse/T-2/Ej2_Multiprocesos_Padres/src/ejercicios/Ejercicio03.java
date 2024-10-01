package ejercicios;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) throws IOException {
		// Aqui pido el dato a mandar al proceso hijo
		Scanner sc = new Scanner(System.in);
		String input;

			System.out.println("Escribe un texto:");
			input = sc.nextLine();

		// Directorio del porceso que quiero llamar
		File directorio = new File(
				"E:\\Escritorio\\Git_REPOSITORIOS\\Curso02\\PSP+PMDM\\PSP\\Eclipse\\T-2\\Ej2_Multiprocesos_Hijos\\bin");
		// Tipo de proceso y archivo (depende del especificdo)
		ProcessBuilder pb = new ProcessBuilder("java", "ejercicios.Ejercicio03");
		// Agrego donde esta el programa
		pb.directory(directorio);

		Process p = pb.start();

		// Aui mandas el proceso al hijo
		OutputStream os = p.getOutputStream();
		os.write(input.getBytes());
		os.flush(); // vacía el buffer de salida
		os.close();

		try {
			int exitVal = p.waitFor();

			switch (exitVal) {
			case 1:
				System.out.println("NO es un palíndromo");
				break;
			case 0:
				System.out.println("Es un palíndromo");
				break;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
