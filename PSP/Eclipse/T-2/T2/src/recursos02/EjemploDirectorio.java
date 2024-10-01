package recursos02;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class EjemploDirectorio {
	public static void main(String[] args) throws IOException {

		
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DIR");
                pb.directory(new File("c:/Julio/"));
                Process p = pb.start();
		

		// COMPROBACION DE ERROR - 0 bien - 1 mal
		int exitVal=-1;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (exitVal==0 ) {
			try {
	
				InputStream is = p.getInputStream();
				// mostramos en pantalla caracter a caracter
				 int c;
				 while ((c = is.read()) != -1)
					System.out.print((char) c);
				 is.close();
				System.exit(0);
			
			} catch (Exception e) {
				System.exit(-1);
				e.printStackTrace();
			}
		}
	}
}