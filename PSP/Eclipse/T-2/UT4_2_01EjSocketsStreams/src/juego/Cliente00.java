package juego;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente00 {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		String Host = "localhost";
		int Puerto = 6000;

		System.out.println("Programa Cliente iniciado");
		Socket cliente = new Socket(Host, Puerto);

//		flujo salida a servidor
		DataOutputStream flujoout = new DataOutputStream(cliente.getOutputStream());
//		flujo entrada a cliente
		DataInputStream flujoin = new DataInputStream(cliente.getInputStream());
		Scanner sc = new Scanner(System.in);
		int cc = 0, cs = 0, aux = 0;

		while (cc < 3 && cs < 3) {
			while (aux > 3 || aux < 1) {
				System.out.println("Escoge que quieres jugar\n" + "\t 1. Piedra" + "\t 2. Papel" + "\t 3. Tijera");
				try {
					aux = Integer.parseInt(sc.nextLine());
				} catch (Exception e) {
					aux=0;
				}
			}
//		envio algo a servidor
			flujoout.writeInt(aux);
			
			aux = flujoin.readInt();

			if (aux == 0) {
				cc++;
				System.out.println("Esta ronda es tuya");
			} else if (aux == 1){
				cs++;
				System.out.println("Cagaste");
			} else {
				System.out.println("Empate");
			}
			aux=0;
		}
		
		if(cc == 3) {
			System.out.println("Ganaste la partida");
		} else if (cs == 3) {
			System.out.println("Perdiste la partida");
		} else {
			System.out.println("Error de algo");
		}
		
//		cerrar todo
		flujoin.close();
		flujoout.close();
		cliente.close();
		System.out.println("Cliente cerrado.");
	}

}
