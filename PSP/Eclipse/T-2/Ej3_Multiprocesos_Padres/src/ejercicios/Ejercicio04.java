package ejercicios;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) throws IOException {
		// Directorio del porceso que quiero llamar
		File directorio = new File(
				"E:\\Escritorio\\Git_REPOSITORIOS\\Curso02\\PSP-PMDM\\PSP\\Eclipse\\T-2\\Ej2_Multiprocesos_Hijos\\bin");
		// Tipo de proceso y archivo (depende del especificdo)
		ProcessBuilder pb = new ProcessBuilder("java", "ejercicios.Ejercicio04");
		// Agrego donde esta el programa
		pb.directory(directorio);


		// Aqui pido el dato a mandar al proceso hijo
		Scanner sc = new Scanner(System.in);
		String input, respuesta="";
		System.out.println("Escribe el nombre de la asignatura:");

		
//		todo hacr que se cierre en el primer *
		do {
			input = sc.nextLine();
			respuesta = input;
			
			System.out.println("Escribe el nombre del fichero:");
			input = sc.nextLine();
			respuesta = respuesta + "\n" + input + "\n";
			

			Process p = pb.start();
			
			// Aui mandas el proceso al hijo
			OutputStream os = p.getOutputStream();
			os.write(respuesta.getBytes());
			os.flush(); // vacía el buffer de salida
//			os.close();

			try {
				int exitVal = p.waitFor();

				switch (exitVal) {
				case -1:
					System.out.println("Error de ejecucion.");
					break;
				case 0:
					try {
						InputStream is = p.getInputStream();
						Scanner sc2 = new Scanner(is);
						while (sc2.hasNext() == true) {
							String salida = sc2.nextLine();
							System.out.println(salida);
						}
//						is.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Escribe el nombre de la asignatura:");
			
		} while (!input.equals("*"));

	}

}
