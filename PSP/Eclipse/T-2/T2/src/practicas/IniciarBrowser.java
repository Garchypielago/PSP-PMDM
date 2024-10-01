package practicas;
import java.io.File;
import java.io.IOException;

public class IniciarBrowser {

	static int retorno =-2;
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ProcessBuilder pb = new ProcessBuilder("C:/Users/garch/AppData/Local/Programs/Opera GX/opera.exe", "https://aquasella.com");
		Process p = pb.start();
		
		retorno = p.waitFor();
		System.out.println("llegamos aqui cuando la ejecuccion del proceso finaliza");
		System.out.println("la ejecucion retorna: " + retorno);
	}

}
