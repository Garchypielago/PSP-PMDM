package ej02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class Partida02_Bup extends Thread {

	private Socket cliente = null;
	private Jugada02 jugada;
	private String registro;
	private static int nCliente = 0;
	
	public Partida02_Bup(Socket cliente){
		this.cliente = cliente;
		this.registro = "Registro de partida de Cliente" + ++nCliente + "\n";
	}

	@Override
	public void run() {
		try {

			ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
			
			ObjectOutputStream outObjeto;
			outObjeto = new ObjectOutputStream(cliente.getOutputStream());

			int ganadas = 0, perdidas = 0;

			while (ganadas < 3 && perdidas < 3) {
				
				jugada = ((Jugada02) inObjeto.readObject());
				registro += "El Cliente"+nCliente+" ha jugado: " + jugada.getCliente() + ", y ha cogido par: " + jugada.isClientePar() + "\n";

				jugada.jugadaServidor(new Random().nextInt(11));
				registro += "Jugada random: " + jugada.getServidor() + "\n";

				if (jugada.getGanador().equalsIgnoreCase("Servidor")) {
					registro += "He ganado, vamos: " + ++ganadas + "-" + perdidas + "\n";
				} else {
					registro += "He perdido, vamos: " + ganadas + "-" + ++perdidas + "\n";
				}

//	envio a cliente
				outObjeto.writeObject(jugada);

			}

			if (ganadas >= 3) {
				registro += "HE GANADO!";
			} else {
				
				registro += "He perdido...";
			}
			
			System.out.println(registro);

//	cerrar todo
			inObjeto.close();
			outObjeto.close();

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
