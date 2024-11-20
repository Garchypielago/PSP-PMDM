package ej02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor02 {

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
		String salida =  Double.toString(Math.pow(Integer.parseInt(flujoin.readUTF()), 2));
		flujoout.writeUTF(salida);
		System.out.println("Devuelto cuadrado.");
		
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
