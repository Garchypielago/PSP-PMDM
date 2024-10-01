package ejercicios;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) throws IOException {

		
		File directorio = new File(
				"E:\\Escritorio\\Git_REPOSITORIOS\\Curso02\\PSP+PMDM\\PSP\\Eclipse\\T-2\\Ej2_Multiprocesos_Hijos\\bin");
		
		ProcessBuilder pb = new ProcessBuilder("java", "ejercicios.Ejercicio03");
		
		pb.directory(directorio);

		File fBat = new File("E:\\Escritorio\\Git_REPOSITORIOS\\Curso02\\PSP+PMDM\\PSP\\Eclipse\\T-2\\Ej3_Multiprocesos_Padres\\TXT\\entrada_ej03.txt");
		pb.redirectInput(fBat);
		File fOut = new File("E:\\Escritorio\\Git_REPOSITORIOS\\Curso02\\PSP+PMDM\\PSP\\Eclipse\\T-2\\Ej3_Multiprocesos_Padres\\TXT\\salida_ej03.txt");
		pb.redirectOutput(fOut);
		File fErr = new File("E:\\Escritorio\\Git_REPOSITORIOS\\Curso02\\PSP+PMDM\\PSP\\Eclipse\\T-2\\Ej3_Multiprocesos_Padres\\TXT\\error_ej03.txt");
		pb.redirectError(fErr);

		Process p = pb.start();

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
