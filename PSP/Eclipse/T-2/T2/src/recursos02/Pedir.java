package recursos02;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class Pedir {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.out.println("Escribe un número:" );
		Scanner sc = new Scanner(System.in);
	        // entrada de una cadena
        	String respuesta = sc.nextLine();
		// TODO Auto-generated method stub

		//creamos objeto File al directorio donde esta Ejemplo2
		File directorio = new File("C:\\Users\\jhorn\\eclipse-workspace\\UT2\\UT2_9_CalcularParImpar\\bin");	

		//El proceso a ejecutar es Ejemplo2			
		ProcessBuilder pb = new ProcessBuilder("java", "mispaquetes.Calcular");
		
	    //se establece el directorio donde se encuentra el ejecutable
	    pb.directory(directorio);
		
	    //se ejecuta el proceso
		Process p = pb.start();
		
		respuesta = respuesta+"\n"; 
		OutputStream os = p.getOutputStream();
		os.write(respuesta.getBytes());
		//os.flush(); // vacía el buffer de salida
		os.close();


		// COMPROBACION DE ERROR - 0 bien - 1 mal	
		int exitVal = -1;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (exitVal == 0) {
		   //obtener la salida devuelta por el proceso
			try {
				InputStream is = p.getInputStream();
				/*
				int c;
				while ((c = is.read()) != -1)
					System.out.print((char) c);
				*/	
				/*
				 * InputStreamReader isr = new InputStreamReader(is); BufferedReader br = new
				 * BufferedReader (isr); String salida = br.readLine();
				 */
				Scanner sc2 = new Scanner(is);				
				if(sc2.hasNext() == true) {
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
