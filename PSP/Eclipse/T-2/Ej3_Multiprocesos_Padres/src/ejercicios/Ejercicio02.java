package ejercicios;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) throws IOException {

		// Directorio del porceso que quiero llamar
		File directorio = new File(
				"E:\\Escritorio\\Git_REPOSITORIOS\\Curso02\\PSP+PMDM\\PSP\\Eclipse\\T-2\\Ej2_Multiprocesos_Hijos\\bin");
		// Tipo de proceso y archivo (depende del especificdo)
		ProcessBuilder pb = new ProcessBuilder("java", "ejercicios.Ejercicio02");
		// Agrego donde esta el programa
		pb.directory(directorio);

		File fBat = new File("E:\\Escritorio\\Git_REPOSITORIOS\\Curso02\\PSP+PMDM\\PSP\\Eclipse\\T-2\\Ej3_Multiprocesos_Padres\\TXT\\entrada_ej02.txt");
		pb.redirectInput(fBat);
		File fOut = new File("E:\\Escritorio\\Git_REPOSITORIOS\\Curso02\\PSP+PMDM\\PSP\\Eclipse\\T-2\\Ej3_Multiprocesos_Padres\\TXT\\salida_ej02.txt");
		pb.redirectOutput(fOut);
		File fErr = new File("E:\\Escritorio\\Git_REPOSITORIOS\\Curso02\\PSP+PMDM\\PSP\\Eclipse\\T-2\\Ej3_Multiprocesos_Padres\\TXT\\error_ej02.txt");
		pb.redirectError(fErr);

		Process p = pb.start();

		try {
			int exitVal = p.waitFor();

			switch (exitVal) {
			case -1:
				System.out.println("Error de ejecucion, un valor no es un numero");
				break;
			case 0:
				break;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
