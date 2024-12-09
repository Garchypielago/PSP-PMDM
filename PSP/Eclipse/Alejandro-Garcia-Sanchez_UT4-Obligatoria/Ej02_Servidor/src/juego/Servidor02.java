package juego;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor02 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int nPuerto = 6000;
		ServerSocket server = new ServerSocket(nPuerto);
		Socket cliente = null;

		while (true) {
			System.out.println("Esperadno clinete...");
			cliente = server.accept();
			
			new Partida02(cliente).start();;
		}

//		server.close();
//		System.out.println("Servidor cerrado.");
	}

}
