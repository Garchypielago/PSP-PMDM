package ej01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int nPuerto = 6000;
		ServerSocket server =  new ServerSocket(nPuerto);
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
		
//		envio a cliente
		flujoout.writeUTF(flujoin.readUTF().toUpperCase());
		System.out.println("Devuelto mayusculas.");
		
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
