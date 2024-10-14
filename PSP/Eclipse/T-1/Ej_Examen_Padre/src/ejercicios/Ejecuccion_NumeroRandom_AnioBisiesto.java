package ejercicios;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Ejecuccion_NumeroRandom_AnioBisiesto {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File directorio = new File(
				"E:\\Escritorio\\Git_REPOSITORIOS\\Curso02\\PSP+PMDM\\PSP\\Eclipse\\T-2\\Ej_Examen_Hijos\\bin");
		ProcessBuilder pb = new ProcessBuilder("java", "ejercicios.NumeroRandom");
		pb.directory(directorio);

		ProcessBuilder pb2 = new ProcessBuilder("java", "ejercicios.AnioBisiesto");
		pb2.directory(directorio);

		Process p = pb.start();
		Process p2 = pb2.start();

		try {
			InputStream is = p.getInputStream();
			Scanner sc = new Scanner(is);
			String salida = sc.nextLine();
			
			p.waitFor();
			
			OutputStream os = p2.getOutputStream();
			// esto pasa bytes, no el numero, como lo tenia nates que estaba mal (ont salida)
			os.write(salida.getBytes());
			os.close();
			
			p2.waitFor();

			InputStream is2 = p2.getInputStream();
			sc = new Scanner(is2);
			String salida2 = sc.nextLine();
			
			System.out.println(salida2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
