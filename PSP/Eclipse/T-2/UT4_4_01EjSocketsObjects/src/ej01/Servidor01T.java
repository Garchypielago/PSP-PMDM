package ej01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Servidor01T {

	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		int nPuerto = 6000;
		ServerSocket server = new ServerSocket(nPuerto);
		Socket cliente = null;
		Jugada01 jugada;

		System.out.println("Esperadno cliente...");
		cliente = server.accept();

//		flujo salida a cliente
		ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
//		flujo entrada a servidor
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());

		int ganadas = 0, perdidas = 0;

		while (ganadas < 3 && perdidas < 3) {
//		llegada cliente
			jugada = ((Jugada01) inObjeto.readObject());
			System.out.println("El ha jugado: " + jugada.getCliente() + ", y ha cogido par: " + jugada.isClientePar());

			jugada.jugadaServidor(new Random().nextInt(11));
			System.out.println("Jugada random: " + jugada.getServidor());

			if (jugada.getGanador().equalsIgnoreCase("Servidor")) {
				System.out.println("He ganado, vamos: " + ++ganadas + "-" + perdidas);
			} else {
				System.out.println("He perdido, vamos: " + ganadas + "-" + ++perdidas);
			}

//		envio a cliente
			outObjeto.writeObject(jugada);

		}

		if (ganadas >= 3) {
			System.out.println("HE GANADO!");
		} else {
			System.out.println("He perdido...");
		}

//		cerrar todo
		inObjeto.close();
		outObjeto.close();
		cliente.close();
		server.close();
		System.out.println("Servidor cerrado.");
	}

}
