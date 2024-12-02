package ej02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

import ej01.Jugada01;

public class Servidor02T_Bup {

	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		int nPuerto = 6000;
		ServerSocket server = new ServerSocket(nPuerto);
		Socket cliente = null;

		while(true) {
			System.out.println("Esperadno cliente...");
			cliente = server.accept();
			System.out.println("Cliente aceptdo.");

			new Partida02_Bup(cliente).start();
			System.out.println("Cliente aceptdo y jugando.\n");
		}



//		cerrar todo
//		inObjeto.close()
//		cliente.close();
//		server.close();
//		System.out.println("Servidor cerrado.");
	}

}
