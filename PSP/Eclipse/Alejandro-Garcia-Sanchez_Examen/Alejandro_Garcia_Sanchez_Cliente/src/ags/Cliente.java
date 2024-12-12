package ags;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		String Host = "localhost";
		int Puerto = 2012;

		System.out.println("Programa Cliente iniciado");
		Socket cliente = new Socket(Host, Puerto);

//		flujo salida a servidor
		DataOutputStream flujoout = new DataOutputStream(cliente.getOutputStream());
//		flujo entrada a cliente
		DataInputStream flujoin = new DataInputStream(cliente.getInputStream());
		Scanner sc = new Scanner(System.in);
		boolean enJuego = true;

		while (enJuego) {
			int aux = -1;
			
			while (aux > 100 || aux < 0) {
				System.out.println("Escribe que quieres jugar(0-100):");
				try {
					aux = Integer.parseInt(sc.nextLine());
				} catch (Exception e) {
					aux=-1;
					System.out.println("ERROR debes jugar del 0 al 100.");
				}
			}
			
			flujoout.writeInt(aux);
			System.out.println(flujoin.readUTF());
			enJuego=flujoin.readBoolean();
		}

		System.out.println(flujoin.readUTF());
		
//		cerrar todo
		flujoin.close();
		flujoout.close();
		cliente.close();
		System.out.println("Cliente cerrado.");
	}

}
