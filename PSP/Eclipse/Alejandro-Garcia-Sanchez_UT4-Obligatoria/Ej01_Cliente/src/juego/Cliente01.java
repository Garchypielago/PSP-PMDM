package juego;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente01 {

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
		int ganadas = 0, perdidas = 0, aux = 0;

		while (ganadas < 3 && perdidas < 3) {
			while (aux > 3 || aux < 1) {
				System.out.println("Escoge que quieres jugar\n" + "\t 1. Piedra" + "\t 2. Papel" + "\t 3. Tijera");
				try {
					aux = Integer.parseInt(sc.nextLine());
				} catch (Exception e) {
					System.out.println("ERROR: Escribe 1, 2 o 3.");
					aux=0;
				}
			}
//		envio algo a servidor
			flujoout.writeInt(aux);
			
			aux = flujoin.readInt();

			if (aux == 0) {
				System.out.println("Esta ronda es tuya. Vais: " + ++ganadas + "-"+ perdidas);
			} else if (aux == 1){
				System.out.println("Perdiste la ronda. Vais: " + ganadas + "-" + ++perdidas);
			} else {
				System.out.println("Empate. Vais: " + ganadas + "-" + perdidas);
			}
			aux=0;
		}
		
		if(ganadas == 3) {
			System.out.println("Ganaste la partida.");
		} else if (perdidas == 3) {
			System.out.println("Perdiste la partida.");
		}
		
//		cerrar todo
		flujoin.close();
		flujoout.close();
		cliente.close();
		System.out.println("Cliente cerrado.");
	}

}
