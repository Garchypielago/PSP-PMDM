package juego;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;

public class Partida02 extends Thread {

	private Socket cliente;
	private String registro;
	private static int nPartida = 0;

	public Partida02(Socket cliente) {
		this.cliente = cliente;
		this.registro = "Registro de partida n" + ++nPartida + "\n";
	}

	@Override
	public void run() {
		try {
//			flujo de datos
			DataInputStream flujoin = new DataInputStream(cliente.getInputStream());

//			salida al clinete
			DataOutputStream flujoout = new DataOutputStream(cliente.getOutputStream());

			int ganadasCli = 0, ganadasSer = 0, aux = 0, jugada = 0;

			while (ganadasCli < 3 && ganadasSer < 3) {
				jugada = flujoin.readInt();
				this.registro += "\tRecibiendo jugada: \t" + jugada + "\n";

				aux = new Random().nextInt(3) + 1;
				this.registro += "\tCreando jugada: \t" + aux + "\n";

				if (aux == jugada) {
					flujoout.writeInt(2);
					this.registro += "\tResultado de jugada es empate. Vamos: " + ganadasSer + "-" + ganadasCli + "\n";
				} else if (aux == 2 && jugada == 1) {
					flujoout.writeInt(1);
					this.registro += "\tResultado de jugada es ganada. Vamos: " + ++ganadasSer + "-" + ganadasCli + "\n";

				} else if (aux == 3 && jugada == 2) {
					flujoout.writeInt(1);
					this.registro += "\tResultado de jugada es ganada. Vamos: " + ++ganadasSer + "-" + ganadasCli + "\n";

				} else if (aux == 1 && jugada == 3) {
					flujoout.writeInt(1);
					this.registro += "\tResultado de jugada es ganada. Vamos: " + ++ganadasSer + "-" + ganadasCli + "\n";

				} else {
					flujoout.writeInt(0);
					this.registro += "\tResultado de jugada es perdida. Vamos: " + ganadasSer + "-" + ++ganadasCli + "\n";
				}

			}
			
			System.out.println(registro);

//			cerrar todo
			flujoin.close();
			flujoout.close();
			cliente.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
