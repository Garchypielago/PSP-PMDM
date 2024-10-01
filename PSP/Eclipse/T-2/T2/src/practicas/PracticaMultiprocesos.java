package practicas;
import java.io.*;
import java.util.Scanner;

public class PracticaMultiprocesos {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		
		while (opcion == 0) {
		
		System.out.println("Que quieres hacer: "+
							"\n 1. Apagar" +
							"\n 2. Suspender" +
							"\n 3. Reiniciar");
		
		opcion = Integer.parseInt(sc.nextLine());
		
		System.out.println("¿En cuantos segundos quieres que pase?");
		
		int tiempo = Integer.parseInt(sc.nextLine());
		
		switch (opcion) {
		case 1:
			ProcessBuilder pb = new ProcessBuilder("shutdown", "-s", "-t", String.valueOf(tiempo));
			Process p = pb.start();
			break;
			
		case 2:
			ProcessBuilder pb2 = new ProcessBuilder("shutdown", "-h", "-t", String.valueOf(tiempo));
			Process p2 = pb2.start();
			break;
			
		case 3:
			ProcessBuilder pb3 = new ProcessBuilder("shutdown", "-r", "-t", String.valueOf(tiempo));
			Process p3 = pb3.start();
			break;
			
		default:
			opcion = 0;
		}
		}
		sc.close();
	}

}
