package recursos01;

import java.io.IOException;

public class EjecutarAplicacionProcessBuilder
{

	static int retorno =-2;//En caso de que se haya ejecutado correctamente devolver� 0
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		// TODO Auto-generated method stub
		ProcessBuilder pb = new ProcessBuilder("C:\\windows\\notepad.exe"); //"notas.txt"
		//pb.directory(new File("c:/Julio/"));

		Process p = null;
		p = pb.start();
				
		retorno = p.waitFor();
		System.out.println("Llegamos aqu� cuando la ejecuci�n del proceso finaliza");
		System.out.println("La ejecuci�n devuelve: "+retorno);
	}

}
