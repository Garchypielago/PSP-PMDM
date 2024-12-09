package juego;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Servidor01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int nPuerto = 6000;
		ServerSocket server = new ServerSocket(nPuerto);
		Socket cliente1 = null, cliente2 = null;

		System.out.println("Esperadno cliente01...");
		cliente1 = server.accept();
		
		System.out.println("Esperadno cliente02...");
		cliente2 = server.accept();

//		flujo de datos c1
		InputStream is1 = null;
		is1 = cliente1.getInputStream();
		DataInputStream flujoin1 = new DataInputStream(is1);

//		flujo de datos c2
		InputStream is2 = null;
		is2 = cliente2.getInputStream();
		DataInputStream flujoin2 = new DataInputStream(is2);
		

//		salida al clinete c1
		OutputStream os1 = null;
		os1 = cliente1.getOutputStream();
		DataOutputStream flujoout1 = new DataOutputStream(os1);
		
//		salida al clinete c2
		OutputStream os2 = null;
		os2 = cliente2.getOutputStream();
		DataOutputStream flujoout2 = new DataOutputStream(os2);

		int ganadas1 = 0, ganadas2 = 0, jugada1 = 0, jugada2 = 0;

		while (ganadas1 < 3 && ganadas2 < 3) {
			jugada1 = flujoin1.readInt();
			System.out.println("Recibiendo jugada cliente1: " + jugada1);

			jugada2 = flujoin2.readInt();
			System.out.println("Recibiendo jugada cliente2: " + jugada2);

			if (jugada2 == jugada1) {
				flujoout1.writeInt(2);
				flujoout2.writeInt(2);
			} else if (jugada2 == 2 && jugada1 == 1) {
				ganadas2++;
				flujoout1.writeInt(1);
				flujoout2.writeInt(0);
			} else if (jugada2 == 3 && jugada1 == 2) {
				ganadas2++;
				flujoout1.writeInt(1);
				flujoout2.writeInt(0);
			} else if (jugada2 == 1 && jugada1 == 3) {
				ganadas2++;
				flujoout1.writeInt(1);
				flujoout2.writeInt(0);
			} else {
				ganadas1++;
				flujoout1.writeInt(0);
				flujoout2.writeInt(1);
			}

		}

//		cerrar todo
		is1.close();
		flujoin1.close();
		os1.close();
		flujoout1.close();
		cliente1.close();
		is2.close();
		flujoin2.close();
		os2.close();
		flujoout2.close();
		cliente2.close();
		server.close();
		System.out.println("Servidor cerrado.");
	}

}
