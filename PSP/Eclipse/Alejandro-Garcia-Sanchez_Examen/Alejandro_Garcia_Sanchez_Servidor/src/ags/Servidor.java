package ags;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Servidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int nPuerto = 2012;
		ServerSocket server = new ServerSocket(nPuerto);
		Socket cliente1 = null;

		System.out.println("Esperadno cliente...");
		cliente1 = server.accept();

//		flujo de datos
		InputStream is = null;
		is = cliente1.getInputStream();
		DataInputStream flujoin = new DataInputStream(is);

//		salida al clinete
		OutputStream os = null;
		os = cliente1.getOutputStream();
		DataOutputStream flujoout = new DataOutputStream(os);

		
		int cc = 5, jugada = -1;
		int jugadaGanadora = new Random().nextInt(101);
		System.out.println("La jugada ganadora es: \n\t" + jugadaGanadora);

		while (cc>0 && jugada!=jugadaGanadora) {
			jugada = flujoin.readInt();
			System.out.println("Recibiendo jugada: \n\t" + jugada);

			if(jugada>jugadaGanadora) {
				flujoout.writeUTF("El número ganador es menor que el escrito. Intentos restantes: "+ cc);
			} else if(jugada<jugadaGanadora) {
				flujoout.writeUTF("El número ganador es mayor que el escrito. Intentos restantes: "+ cc);
			}

			if (jugada==jugadaGanadora) {
				flujoout.writeUTF("VAYA, acertaste.");
				flujoout.writeBoolean(false);
			} else if(--cc==0){
				flujoout.writeBoolean(false);
			} else {
				flujoout.writeBoolean(true);
			}
		}
		
		if(cc==0) {
		flujoout.writeUTF("La partida es mía, suerete a la proxima.");
		} else {
			flujoout.writeUTF("La proxima vez te lo pondre mas complicado.");
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
