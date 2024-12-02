package ej;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class Partida03 extends Thread {

	private Socket cliente01, cliente02;
	private Jugada03 jugada;
	private String registro;
	private static int nPartida = 0;

	public Partida03(Socket cliente01, Socket cliente02) {
		this.cliente01 = cliente01;
		this.cliente02 = cliente02;
		this.jugada = new Jugada03();
		this.registro = "Registro de partida n" + ++nPartida + "\n";
	}

	@Override
	public void run() {
		try {
			ObjectInputStream inObjeto01 = new ObjectInputStream(cliente01.getInputStream());
			ObjectOutputStream outObjeto01 = new ObjectOutputStream(cliente01.getOutputStream());

			ObjectInputStream inObjeto02 = new ObjectInputStream(cliente02.getInputStream());
			ObjectOutputStream outObjeto02 = new ObjectOutputStream(cliente02.getOutputStream());

			int ganadas01 = 0, ganadas02 = 0, contador = 0;

			while (ganadas01 < 3 && ganadas02 < 3) {

				if (contador%2==0) {
//					true
					outObjeto01.writeObject(jugada);
//					false
					jugada.changeTurno();
					outObjeto02.writeObject(jugada);

					jugada = ((Jugada03) inObjeto01.readObject());
					registro += "El Cliente01 ha jugado: " + jugada.getCliente01() + ", y ha cogido par: "
							+ jugada.isCliente01Par() + "\n";
					
					jugada.mergeJugada((Jugada03) inObjeto02.readObject());
					registro += "El Cliente02 ha jugado: " + jugada.getCliente02() + "\n";

					jugada.ganador();
					outObjeto02.writeObject(jugada);
//					true
					jugada.changeTurno();
					jugada.ganador();
					outObjeto01.writeObject(jugada);
					

					if (jugada.getGanador().equalsIgnoreCase("Gano")) {
						registro += "Ha ganado Cliente01, van: " + ++ganadas01 + "-" + ganadas02 + "\n";
					} else {
						registro += "Ha ganado Cliente02, van: " + ganadas01 + "-" + ++ganadas02 + "\n";
					}
					

				} else {
//					true
					outObjeto02.writeObject(jugada);
//					false
					jugada.changeTurno();
					outObjeto01.writeObject(jugada);

					jugada = ((Jugada03) inObjeto02.readObject());
					registro += "El Cliente02 ha jugado: " + jugada.getCliente01() + ", y ha cogido par: "
							+ jugada.isCliente01Par() + "\n";
					
					jugada.mergeJugada((Jugada03) inObjeto01.readObject());
					registro += "El Cliente01 ha jugado: " + jugada.getCliente02() + "\n";

					jugada.ganador();
					outObjeto01.writeObject(jugada);
//					true
					jugada.changeTurno();
					jugada.ganador();
					outObjeto02.writeObject(jugada);
					

					if (jugada.getGanador().equalsIgnoreCase("Pierdo")) {
						registro += "Ha ganado Cliente01, van: " + ++ganadas01 + "-" + ganadas02 + "\n";
					} else {
						registro += "Ha ganado Cliente02, van: " + ganadas01 + "-" + ++ganadas02 + "\n";
					}
				}
				contador++;
			}

			if (ganadas01 >= 3) {
				registro += "Ha gaando Cliente01";
			} else {
				registro += "Ha gaando Cliente02";
			}

			System.out.println(registro);

//	cerrar todo
			inObjeto01.close();
			outObjeto01.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	flujo entrada a servidor
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
