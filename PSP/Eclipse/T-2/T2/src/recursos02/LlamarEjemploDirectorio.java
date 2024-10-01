package recursos02;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class LlamarEjemploDirectorio {
	public static void main(String[] args) throws IOException, InterruptedException {

		//creamos objeto File al directorio donde esta Ejemplo2
		File directorio = new File("C:\\Users\\jhorn\\eclipse-workspace\\Ejemplo1\\bin");	

		//El proceso a ejecutar es Ejemplo2			
		ProcessBuilder pb = new ProcessBuilder("java", "Ejemplo1.GeneraDir");

	    //se establece el directorio donde se encuentra el ejecutable
	    pb.directory(directorio);
	        
		System.out.printf("Directorio de trabajo: %s%n",pb.directory());

	    //se ejecuta el proceso
		Process p = pb.start();
		
		// COMPROBACION DE ERROR - 0 bien - 1 mal
		int exitVal = -1;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(exitVal==0) {

		   //obtener la salida devuelta por el proceso
			try {			
				InputStream is = p.getInputStream();
				int c;
				while ((c = is.read()) != -1)
					System.out.print((char) c);
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}	
}
