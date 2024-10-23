package Main;
import java.io.*;
import java.util.*;

public class LeerFichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Aqui pido el dato a mandar al proceso hijo
		Scanner sc_generar = new Scanner(System.in);
		
		System.out.println("Escribe el nombre del nombre del archivo:");
		String nombre = sc_generar.nextLine();

		System.out.println("Escribe la ruta del fichero (acabalo en barra):");
		String path = sc_generar.nextLine();

		System.out.println("Escribe el número de transferencias a generar:");
		int numero = Integer.parseInt(sc_generar.nextLine());
		
		String inputs = nombre + "\n" + path + "\n" +  String.valueOf(numero) + "\n";

		Double saldo = ((double) (new Random().nextInt(200000, 300001)) / 100) * numero;

		//aqui llamo al proceso01
		int exitVal = generacionFichero(inputs);

		switch (exitVal) {
		case -2:
			System.out.println("No ha llegado el archivo de transferencias.");
			break;
		case -1:
			System.out.println("Error al generar el archivo.");
			break;
		case 0:
			//tdo la parte de hilos
			System.out.println("todo por ahora bn");
			break;
		}

	}

	public static int generacionFichero(String input){
		try {
			File directorio = new File("..\\GenereacionTransferencias\\bin");
			ProcessBuilder generar = new ProcessBuilder("java", "generacion.Generacion");
			// Agrego donde esta el programa
			generar.directory(directorio);
			Process p_generar = generar.start();

			
			// Aui mandas el proceso al hijo
			OutputStream os = p_generar.getOutputStream();
			os.write(input.getBytes());
			os.flush(); // vacía el buffer de salida
			os.close();
			
			int exitVal = -1;
			exitVal = p_generar.waitFor();
			
			return exitVal;

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	

}