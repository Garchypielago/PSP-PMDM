package ej01;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente01T {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		String Host = "localhost";
		int Puerto = 6000;
		Jugada01 jugada;

		System.out.println("Programa Cliente iniciado");
		Socket cliente = new Socket(Host, Puerto);
//		flujo salida a servidor
		ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
//		flujo entrada a cliente
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());

		Scanner sc = new Scanner(System.in);
		int ganadas = 0, perdidas = 0;

		while (ganadas < 3 && perdidas < 3) {
			System.out.println("Escribe que quieres par o impar: ");
			Boolean par = sc.nextLine().equalsIgnoreCase("par");
			System.out.println("Escribe la jugada (0-10): ");
			int num = Integer.parseInt(sc.nextLine());
			jugada = new Jugada01(num, par);

//		 envio al servidor
			outObjeto.writeObject(jugada);

//		llegada de servidor
			jugada = ((Jugada01) inObjeto.readObject());

			if (jugada.getGanador().equalsIgnoreCase("Cliente")) {
				System.out.println("Has ganado, vamos: " + ++ganadas + "-" + perdidas);
			} else {
				System.out.println("Has perdido, vamos: " + ganadas + "-" + ++perdidas);
			}
		}

		if (ganadas >= 3) {
			System.out.println("HAS GANADO!");
		} else {
			System.out.println("Has perdido...");
		}

//		cerrar todo
		inObjeto.close();
		outObjeto.close();
		cliente.close();
		System.out.println("Cliente cerrado.");
	}

}
