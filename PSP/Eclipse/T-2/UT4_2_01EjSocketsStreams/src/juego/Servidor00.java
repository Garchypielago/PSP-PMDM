package juego;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Servidor00 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int nPuerto = 6000;
		ServerSocket server = new ServerSocket(nPuerto);
		Socket cliente1 = null;

		System.out.println("Esperadno clinete...");
		cliente1 = server.accept();

//		flujo de datos
		InputStream is = null;
		is = cliente1.getInputStream();
		DataInputStream flujoin = new DataInputStream(is);

//		salida al clinete
		OutputStream os = null;
		os = cliente1.getOutputStream();
		DataOutputStream flujoout = new DataOutputStream(os);

		int cc = 0, cs = 0, aux = 0, jugada = 0;

		while (cc < 3 && cs < 3) {
			jugada = flujoin.readInt();
			System.out.println("Recibiendo jugada: \n\t" + jugada);

			aux = new Random().nextInt(2) + 1;

			if (aux == jugada) {
				flujoout.writeInt(2);
			} else if (aux == 2 && jugada == 1) {
				cs++;
				flujoout.writeInt(1);
			} else if (aux == 3 && jugada == 2) {
				cs++;
				flujoout.writeInt(1);
			} else if (aux == 1 && jugada == 3) {
				cs++;
				flujoout.writeInt(1);
			} else {
				cc++;
				flujoout.writeInt(0);
			}

		}

//		cerrar todo
		is.close();
		flujoin.close();
		os.close();
		flujoout.close();
		cliente1.close();
		server.close();
		System.out.println("Servidor cerrado.");
	}

}
