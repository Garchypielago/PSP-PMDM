package ej;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente03T {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		String Host = "localhost";
		int Puerto = 6000;
		Jugada03 jugada;

		System.out.println("Programa Cliente iniciado");
		Socket cliente = new Socket(Host, Puerto);
//		flujo salida a servidor
		ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
//		flujo entrada a cliente
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());

		Scanner sc = new Scanner(System.in);
		int ganadas = 0, perdidas = 0;
		Boolean par = true;

		while (ganadas < 3 && perdidas < 3) {
			jugada = ((Jugada03) inObjeto.readObject());
			
			if(jugada.getTurno()) {
				System.out.println("Escribe que quieres par o impar: ");
				par = sc.nextLine().equalsIgnoreCase("par");
			}
			
			System.out.println("Escribe la jugada (0-10): ");
			int num = Integer.parseInt(sc.nextLine());
			
			jugada.jugadaCliente(num, par);

//		 envio al servidor
			outObjeto.writeObject(jugada);

//		llegada de servidor
			jugada = ((Jugada03) inObjeto.readObject());

			if (jugada.getGanador().equalsIgnoreCase("Gano")) {
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
