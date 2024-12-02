package ej;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor03T {

	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		int nPuerto = 6000;
		ServerSocket server = new ServerSocket(nPuerto);
		Socket cliente01 = null, cliente02 = null;

		while(true) {
			System.out.println("Esperadno clientes...");
			cliente01 = server.accept();
			System.out.println("Primer cliente aceptdo.");
			cliente02 = server.accept();
			System.out.println("Segundo cliente aceptdo.");

			new Partida03(cliente01, cliente02).start();
			System.out.println("Clientes aceptdos y jugando.\n");
		}



//		cerrar todo
//		inObjeto.close()
//		cliente.close();
//		server.close();
//		System.out.println("Servidor cerrado.");
	}

}
