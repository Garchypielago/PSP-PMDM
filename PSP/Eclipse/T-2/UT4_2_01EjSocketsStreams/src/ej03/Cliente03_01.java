package ej03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente03_01 {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		String Host = "localhost";
		int Puerto = 6000;

		System.out.println("Programa ClienteMayusculas iniciado");
		Socket cliente = new Socket(Host, Puerto);

//		flujo salida a servidor
		DataOutputStream flujoout = new DataOutputStream(cliente.getOutputStream());
		
//		envio algo a servidor
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe el mensaje: ");
		flujoout.writeUTF(sc.nextLine());
		
//		flujo entrada a cliente
		DataInputStream flujoin = new DataInputStream(cliente.getInputStream());
		
//		llegada de servidor
		System.out.println("Recibiendo del servidor: \n\t"+ flujoin.readUTF());
		
//		cerrar todo
		flujoin.close();
		flujoout.close();
		cliente.close();
		System.out.println("Cliente cerrado.");
	}

}
