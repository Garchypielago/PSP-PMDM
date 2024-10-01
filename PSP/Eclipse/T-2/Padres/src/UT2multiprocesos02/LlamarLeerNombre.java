package UT2multiprocesos02;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class LlamarLeerNombre {

	public static void main(String[] args) throws IOException, InterruptedException {

		//Aqui pido el dato a mandar al proceso hijo
		System.out.println("Escribe el nombre:");
		Scanner sc = new Scanner(System.in);
		String respuesta = sc.nextLine();

		//Directorio del porceso que quiero llamar
		File directorio = new File(
				"E:\\Escritorio\\Git_REPOSITORIOS\\Curso02\\PSP+PMDM\\PSP\\Eclipse\\T-2\\Hijos\\bin");
		//Tipo de proceso y archivo (depende del especificdo)
		ProcessBuilder pb = new ProcessBuilder("java", "UT2multiprocesos02.LeerNombre");
		//Agrego donde esta el programa
		pb.directory(directorio);

		Process p = pb.start();

		//Aui mandas el proceso al hijo
		respuesta = respuesta + "\n";
		OutputStream os = p.getOutputStream();
		os.write(respuesta.getBytes());
		// os.flush(); // vacía el buffer de salida
		os.close();

		// COMPROBACION DE ERROR - 0 bien - 1 mal
		int exitVal = -1;
		try {
			exitVal = p.waitFor();
			//imprimo si esta bien o mal
			System.out.println("Valor de Salida: " + exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (exitVal == 0) {
			// Aqui recuperamos la salida del hijo
			try {
				InputStream is = p.getInputStream();
				Scanner sc2 = new Scanner(is);
				if (sc2.hasNext() == true) {
					String salida = sc2.nextLine();
					System.out.println(salida);
				}
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
