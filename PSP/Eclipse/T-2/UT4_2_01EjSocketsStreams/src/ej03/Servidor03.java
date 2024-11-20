package ej03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor03 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int nPuerto1 = 6000;
		int nPuerto2 = 6001;
		ServerSocket server1 = new ServerSocket(nPuerto1);
		ServerSocket server2 = new ServerSocket(nPuerto2);
		Socket cliente = null;

		InputStream is = null;
		OutputStream os = null;
		DataInputStream flujoin = null;
		DataOutputStream flujoout = null;

		System.out.println("Esperando a los clientes...");
		cliente = server1.accept();
		cliente = server2.accept();

//		flujo de datos
		is = cliente.getInputStream();
		flujoin = new DataInputStream(is);

//		salida al clinete
		os = cliente.getOutputStream();
		flujoout = new DataOutputStream(os);

		flujoout.writeUTF(flujoin.readUTF().toUpperCase());
		System.out.println("Devuelto mayusculas.");

//		flujo de datos
		is = cliente.getInputStream();
		flujoin = new DataInputStream(is);

//		salida al clinete
		os = cliente.getOutputStream();
		flujoout = new DataOutputStream(os);

//		envio a cliente
		flujoout.writeUTF(flujoin.readUTF().toLowerCase());
		System.out.println("Devuelto minusculas.");

//		cerrar todo
		is.close();
		flujoin.close();
		os.close();
		flujoout.close();
		cliente.close();
		server1.close();
		server2.close();
		System.out.println("Servidor cerrado.");
	}

}
